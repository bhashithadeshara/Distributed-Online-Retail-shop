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

public class AddToShoppingCardServiceImpl extends addToShoppingCardServiceGrpc.addToShoppingCardServiceImplBase implements DistributedTxListener {

    private RetailServer server;

    private ManagedChannel channel = null;

    addToShoppingCardServiceGrpc.addToShoppingCardServiceBlockingStub clientStub = null;

    private Pair<String,Double> tempDataHolder;

    private boolean transactionStatus = false;

    public AddToShoppingCardServiceImpl(RetailServer server){
        this.server = server;
    }

    private void startDistributedTx(String cardId,double quantity) {
        try {
            server.getTransaction2().start(String.valueOf(quantity),String.valueOf(UUID.randomUUID()));
            tempDataHolder = new Pair<>(cardId,quantity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToShoppingCard(AddToShoppingCardRequest request, StreamObserver<AddToShoppingCardResponse> responseObserver) {
        String cardId = request.getCardId();
        double quantity = request.getValue();

        if (server.isLeader()){
            // Act as primary
            try {
                System.out.println("Updating quantity balance as Primary");
                startDistributedTx(cardId,quantity);
                updateSecondaryServers(cardId,quantity);
                System.out.println("going to perform");
                if (quantity > 0){
                    ((DistributedTxCoordinator)server.getTransaction2()).perform();
                } else {
                    ((DistributedTxCoordinator)server.getTransaction2()).sendGlobalAbort();
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
                    ((DistributedTxParticipant)server.getTransaction2()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getTransaction2()).voteAbort();
                }
            } else {
                AddToShoppingCardResponse response = callPrimary(cardId,quantity);
                if (response.getStatus()) {
                    transactionStatus = true;
                }
            }
        }
        AddToShoppingCardResponse response = AddToShoppingCardResponse
                .newBuilder()
                .setStatus(transactionStatus)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void addToCart() {
        if (tempDataHolder != null) {
            String cardId = tempDataHolder.getKey();
            double quantity = tempDataHolder.getValue();
            server.addToCart(cardId,quantity);
            System.out.println("cardId " + cardId + " is updated to value " + quantity + " is committed");
            tempDataHolder = null;
        }
    }

    private AddToShoppingCardResponse callServer(String cardId,double quantity, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port)
                .usePlaintext()
                .build();
        clientStub = addToShoppingCardServiceGrpc.newBlockingStub(channel);

        AddToShoppingCardRequest request = AddToShoppingCardRequest
                .newBuilder()
                .setCardId(cardId)
                .setValue(quantity)
                .setIsSentByPrimary(isSentByPrimary)
                .build();
        AddToShoppingCardResponse response = clientStub.addToShoppingCard(request);
        return response;
    }

    private AddToShoppingCardResponse callPrimary(String cardId,double quantity) {
        System.out.println("Calling Primary server");
        String[] currentLeaderData = server.getCurrentLeaderData();
        String IPAddress = currentLeaderData[0];
        int port = Integer.parseInt(currentLeaderData[1]);
        return callServer(cardId,quantity, false, IPAddress, port);
    }

    private void updateSecondaryServers(String cardId,double quantity) throws KeeperException, InterruptedException {
        System.out.println("Updating other servers");
        List<String[]> othersData = server.getOthersData();
        for (String[] data : othersData) {
            String IPAddress = data[0];
            int port = Integer.parseInt(data[1]);
            callServer(cardId,quantity, true, IPAddress, port);
        }
    }

    @Override
    public void onGlobalCommit() {
        addToCart();
    }

    @Override
    public void onGlobalAbort() {
        tempDataHolder = null;
        System.out.println("Transaction Aborted by the Coordinator");
    }
}
