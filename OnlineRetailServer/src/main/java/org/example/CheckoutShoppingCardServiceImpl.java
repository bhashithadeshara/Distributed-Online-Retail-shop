package org.example;

import ds.tutorial.communication.grpc.generated.*;
import ds.tutorials.sycnhronization.DistributedTxCoordinator;
import ds.tutorials.sycnhronization.DistributedTxListener;
import ds.tutorials.sycnhronization.DistributedTxParticipant;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.util.Pair;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class CheckoutShoppingCardServiceImpl extends CheckoutShoppingCardServiceGrpc.CheckoutShoppingCardServiceImplBase implements DistributedTxListener {

    private RetailServer server;

    private ManagedChannel channel = null;

    CheckoutShoppingCardServiceGrpc.CheckoutShoppingCardServiceBlockingStub clientStub = null;

    private Pair<String,Double> tempDataHolder;

    private boolean transactionStatus = false;

    public CheckoutShoppingCardServiceImpl(RetailServer server){
        this.server = server;
    }

    private void startDistributedTx(String itemId,double quantity) {
        try {
            server.getTransaction3().start(String.valueOf(quantity),String.valueOf(UUID.randomUUID()));
            tempDataHolder = new Pair<>(itemId,quantity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkoutShoppingCard(CheckoutShoppingCardRequest request, StreamObserver<CheckoutShoppingCardResponse> responseObserver) {
        String cardId = request.getCardId();
        double quantity = request.getValue();

        if (server.isLeader()){
            // Act as primary
            try {
                System.out.println("Updating shopping cart quantity as Primary");
                startDistributedTx(cardId,quantity);
                updateSecondaryServers(cardId,quantity);
                System.out.println("going to perform");
                if (quantity > 0){
                    ((DistributedTxCoordinator)server.getTransaction3()).perform();
                } else {
                    ((DistributedTxCoordinator)server.getTransaction3()).sendGlobalAbort();
                }
            } catch (Exception e) {
                System.out.println("Error while updating the items quantity" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Updating items quantity on secondary, on Primary's command");
                startDistributedTx(cardId,quantity);
                if (quantity != 0.0d) {
                    ((DistributedTxParticipant)server.getTransaction3()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getTransaction3()).voteAbort();
                }
            } else {
                CheckoutShoppingCardResponse response = callPrimary(cardId,quantity);
                if (response.getStatus()) {
                    transactionStatus = true;
                }
            }
        }
        CheckoutShoppingCardResponse response = CheckoutShoppingCardResponse
                .newBuilder()
                .setStatus(transactionStatus)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void checkOutShoppingCart() {
        if (tempDataHolder != null) {
            String cartId = tempDataHolder.getKey();
            double quantity = tempDataHolder.getValue();
            server.checkOutCart(cartId,quantity);
            tempDataHolder = null;
        }
    }

    private CheckoutShoppingCardResponse callServer(String cardId,double quantity, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port)
                .usePlaintext()
                .build();
        clientStub = CheckoutShoppingCardServiceGrpc.newBlockingStub(channel);

        CheckoutShoppingCardRequest request = CheckoutShoppingCardRequest
                .newBuilder()
                .setCardId(cardId)
                .setValue(quantity)
                .setIsSentByPrimary(isSentByPrimary)
                .build();
        CheckoutShoppingCardResponse response = clientStub.checkoutShoppingCard(request);
        return response;
    }

    private CheckoutShoppingCardResponse callPrimary(String itemId,double quantity) {
        System.out.println("Calling Primary server");
        String[] currentLeaderData = server.getCurrentLeaderData();
        String IPAddress = currentLeaderData[0];
        int port = Integer.parseInt(currentLeaderData[1]);
        return callServer(itemId,quantity, false, IPAddress, port);
    }

    private void updateSecondaryServers(String itemId,double quantity) throws KeeperException, InterruptedException {
        System.out.println("Updating other servers");
        List<String[]> othersData = server.getOthersData();
        for (String[] data : othersData) {
            String IPAddress = data[0];
            int port = Integer.parseInt(data[1]);
            callServer(itemId,quantity, true, IPAddress, port);
        }
    }

    @Override
    public void onGlobalCommit() {
        checkOutShoppingCart();
    }

    @Override
    public void onGlobalAbort() {
        tempDataHolder = null;
        System.out.println("Transaction Aborted by the Coordinator");
    }
}
