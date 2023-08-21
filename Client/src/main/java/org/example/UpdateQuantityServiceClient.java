package org.example;

import ds.tutorial.communication.grpc.generated.UpdateQuantityRequest;
import ds.tutorial.communication.grpc.generated.UpdateQuantityResponse;
import ds.tutorial.communication.grpc.generated.UpdateQuantityServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class UpdateQuantityServiceClient {

    private ManagedChannel channel = null;
    UpdateQuantityServiceGrpc.UpdateQuantityServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public UpdateQuantityServiceClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" +
                port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = UpdateQuantityServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter Item ID, amount to set the quantity :");
            String input[] = userInput.nextLine().trim().split(",");
            String itemId = input[0];
            double quantity = Double.parseDouble(input[1]);
            System.out.println("Requesting server to set the quantity to " + quantity + " for " + itemId.toString());
            UpdateQuantityRequest request = UpdateQuantityRequest
                    .newBuilder()
                    .setItemId(itemId)
                    .setValue(quantity)
                    .setIsSentByPrimary(false)
                    .build();
            UpdateQuantityResponse response = clientStub.updateQuantity(request);
            System.out.printf("Transaction Status " + (response.getStatus() ? "Sucessful" : "Failed"));
            Thread.sleep(1000);
        }
    }
}
