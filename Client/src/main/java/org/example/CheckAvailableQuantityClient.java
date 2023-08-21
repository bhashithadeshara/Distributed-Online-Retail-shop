package org.example;

import ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest;
import ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse;
import ds.tutorial.communication.grpc.generated.CheckAvailableQuantityServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class CheckAvailableQuantityClient {
    private ManagedChannel channel = null;
    CheckAvailableQuantityServiceGrpc.CheckAvailableQuantityServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public CheckAvailableQuantityClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" +
                port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = CheckAvailableQuantityServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter Item ID to check the available quantity :");
            String itemId = userInput.nextLine().trim();
            System.out.println("Requesting server to check the account balance for " + itemId.toString());
            CheckAvailableQuantityRequest request = CheckAvailableQuantityRequest
                    .newBuilder()
                    .setItemId(itemId)
                    .build();
            CheckAvailableQuantityResponse response = clientStub.checkAvailableQuantity(request);
            System.out.printf("Available quantity is " + response.getAvailableQuantity());
            Thread.sleep(1000);
        }
    }
}
