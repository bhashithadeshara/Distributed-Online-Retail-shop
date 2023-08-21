package org.example;

import ds.tutorial.communication.grpc.generated.UpdateQuantityRequest;
import ds.tutorial.communication.grpc.generated.UpdateQuantityResponse;
import ds.tutorial.communication.grpc.generated.UpdateQuantityServiceGrpc;
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

public class UpdateQuantityServiceImpl extends UpdateQuantityServiceGrpc.UpdateQuantityServiceImplBase implements DistributedTxListener {
    private RetailServer server;

    private ManagedChannel channel = null;

    UpdateQuantityServiceGrpc.UpdateQuantityServiceBlockingStub clientStub = null;

    private Pair<String,Double> tempDataHolder;

    private boolean transactionStatus = false;

    public UpdateQuantityServiceImpl(RetailServer server){
        this.server = server;
    }

    private void startDistributedTx(String itemId,double quantity) {
        try {
            server.getTransaction().start(String.valueOf(quantity),String.valueOf(UUID.randomUUID()));
            tempDataHolder = new Pair<>(itemId,quantity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateQuantity(UpdateQuantityRequest request, StreamObserver<UpdateQuantityResponse> responseObserver) {

        String itemId = request.getItemId();
        double quantity = request.getValue();

        if (server.isLeader()){
            // Act as primary
            try {
                System.out.println("Updating quantity balance as Primary");
                startDistributedTx(itemId,quantity);
                updateSecondaryServers(itemId,quantity);
                System.out.println("going to perform");
                if (quantity > 0){
                    ((DistributedTxCoordinator)server.getTransaction()).perform();
                } else {
                    ((DistributedTxCoordinator)server.getTransaction()).sendGlobalAbort();
                }
            } catch (Exception e) {
                System.out.println("Error while updating the items quantity" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Updating items quantity on secondary, on Primary's command");
                startDistributedTx(itemId,quantity);
                if (quantity != 0.0d) {
                    ((DistributedTxParticipant)server.getTransaction()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getTransaction()).voteAbort();
                }
            } else {
                UpdateQuantityResponse response = callPrimary(itemId,quantity);
                if (response.getStatus()) {
                    transactionStatus = true;
                }
            }
        }
        UpdateQuantityResponse response = UpdateQuantityResponse
                .newBuilder()
                .setStatus(transactionStatus)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void updateBalance() {
        if (tempDataHolder != null) {
            String itemId = tempDataHolder.getKey();
            double quantity = tempDataHolder.getValue();
            server.setQuantity(itemId,quantity);
            System.out.println("Item " + itemId + " is updated to value " + quantity + " is committed");
            tempDataHolder = null;
        }
    }

    private UpdateQuantityResponse callServer(String itemId,double quantity, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port)
                .usePlaintext()
                .build();
        clientStub = UpdateQuantityServiceGrpc.newBlockingStub(channel);

        UpdateQuantityRequest request = UpdateQuantityRequest
                .newBuilder()
                .setItemId(itemId)
                .setValue(quantity)
                .setIsSentByPrimary(isSentByPrimary)
                .build();
        UpdateQuantityResponse response = clientStub.updateQuantity(request);
        return response;
    }

    private UpdateQuantityResponse callPrimary(String itemId,double quantity) {
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
        updateBalance();
    }

    @Override
    public void onGlobalAbort() {
        tempDataHolder = null;
        System.out.println("Transaction Aborted by the Coordinator");
    }
}


