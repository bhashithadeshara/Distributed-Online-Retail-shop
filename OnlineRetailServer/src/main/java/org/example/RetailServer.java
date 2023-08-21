package org.example;

import ds.tutorials.sycnhronization.DistributedLock;
import ds.tutorials.sycnhronization.DistributedTx;
import ds.tutorials.sycnhronization.DistributedTxCoordinator;
import ds.tutorials.sycnhronization.DistributedTxParticipant;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class RetailServer {

    private DistributedLock leaderLock;
    private AtomicBoolean isLeader = new AtomicBoolean(false);
    private byte[] leaderData;
    private int serverPort;

    private Map<String,Double> items = new HashMap();

    private Map<String,Double> carts = new HashMap();

    DistributedTx transaction;

    DistributedTx transaction2;

    DistributedTx transaction3;

    UpdateQuantityServiceImpl updateQuantityService;

    CheckAvailableQuantityServiceImpl checkAvailableQuantityService;

    AddToShoppingCardServiceImpl addToShoppingCardService;

    CheckoutShoppingCardServiceImpl checkoutShoppingCardService;

    public static String buildServerData(String IP, int port) {
        StringBuilder builder = new StringBuilder();
        builder.append(IP).append(":").append(port);
        return builder.toString();
    }

    public RetailServer(String host, int port) throws InterruptedException, IOException, KeeperException {
        this.serverPort = port;
        leaderLock = new DistributedLock("RetailServerTestCluster", buildServerData(host, port));

        updateQuantityService = new UpdateQuantityServiceImpl(this);
        checkAvailableQuantityService = new CheckAvailableQuantityServiceImpl(this);
        addToShoppingCardService = new AddToShoppingCardServiceImpl(this);
        checkoutShoppingCardService = new CheckoutShoppingCardServiceImpl(this);
        transaction = new DistributedTxParticipant(updateQuantityService);
        transaction2 = new DistributedTxParticipant(addToShoppingCardService);
        transaction3 = new DistributedTxParticipant(checkoutShoppingCardService);
    }

    private void tryToBeLeader() throws KeeperException, InterruptedException {
        Thread leaderCampaignThread = new Thread(new LeaderCampaignThread());
        leaderCampaignThread.start();
    }

    public DistributedTx getTransaction() {
        return transaction;
    }

    public DistributedTx getTransaction2() {
        return transaction2;
    }

    public DistributedTx getTransaction3() {
        return transaction3;
    }

    public void startServer() throws IOException, InterruptedException, KeeperException {
        Server server = ServerBuilder
                .forPort(serverPort)
                .addService(updateQuantityService)
                .addService(checkAvailableQuantityService)
                .addService(addToShoppingCardService)
                .addService(checkoutShoppingCardService)
                .build();
        server.start();
        System.out.println("RetailServer Started and ready to accept requests on port " + serverPort);

        tryToBeLeader();
        server.awaitTermination();
    }

    public boolean isLeader() {
        return isLeader.get();
    }

    private synchronized void setCurrentLeaderData(byte[] leaderData) {
        this.leaderData = leaderData;
    }

    public synchronized String[] getCurrentLeaderData() {
        return new String(leaderData).split(":");
    }

    public void setQuantity(String itemId,double quantity) {

        items.put(itemId,quantity);
    }

    public void addToCart(String cartId,double quantity){
        carts.put(cartId,quantity);
    }

    public void checkOutCart(String cartId,double quantity){

        for (Map.Entry<String, Double> cart : carts.entrySet()) {

            System.out.println("Card which are created "+cart.getKey());

            if(cart.getKey().equals(cartId)){

                for (Map.Entry<String, Double> item : items.entrySet()) {

                    String itemId = item.getKey();
                    double availableQuantity = item.getValue();

                    if(quantity <= availableQuantity){
                        // reduce the quantity of the item in the inventory by the allocated quantity
                        items.put(itemId, availableQuantity - quantity);

                        carts.put(cartId,0.0);

                        System.out.println("Allocated " + quantity + " " + item + "(s) from the inventory");
                        System.out.println();
                    }else{
                        // print an error message if there is insufficient quantity in the inventory
                        System.out.println("User " + cartId + " couldn't check out " + quantity + " " + item + "(s). Insufficient quantity.");
                        System.out.println();
                    }

                }

            }else{

                System.out.println("Cart Id is incorrect, Please enter correct cart Id");
            }
        }

    }

    public double getAvailableQuantity(String itemId) {

        Double value = items.get(itemId);
        return (value != null) ? value : 0.0;
    }

    public List<String[]> getOthersData() throws KeeperException, InterruptedException {
        List<String[]> result = new ArrayList<>();
        List<byte[]> othersData = leaderLock.getOthersData();

        for (byte[] data : othersData) {
            String[] dataStrings = new String(data).split(":");
            result.add(dataStrings);
        }
        return result;
    }

    class LeaderCampaignThread implements Runnable {
        private byte[] currentLeaderData = null;
        @Override
        public void run() {
            System.out.println("Starting the leader Campaign");

            try {
                boolean leader = leaderLock.tryAcquireLock();

                while (!leader) {
                    byte[] leaderData = leaderLock.getLockHolderData();
                    if (currentLeaderData != leaderData) {
                        currentLeaderData = leaderData;
                        setCurrentLeaderData(currentLeaderData);
                    }
                    Thread.sleep(10000);
                    leader = leaderLock.tryAcquireLock();
                }
                currentLeaderData = null;
                beTheLeader();
            } catch (Exception e){
            }
        }
    }

    private void beTheLeader() {
        System.out.println("I got the leader lock. Now acting as primary");
        isLeader.set(true);
        transaction = new DistributedTxCoordinator(updateQuantityService);
        transaction2 = new DistributedTxCoordinator(addToShoppingCardService);
        transaction3 = new DistributedTxCoordinator(checkoutShoppingCardService);
    }

    public static void main (String[] args) throws Exception{
        if (args.length != 1) {
            System.out.println("Usage executable-name <port>");
        }

        int serverPort = Integer.parseInt(args[0]);
        DistributedLock.setZooKeeperURL("localhost:2181");
        DistributedTx.setZooKeeperURL("localhost:2181");

        RetailServer server = new RetailServer("localhost", serverPort);
        server.startServer();
    }
}
