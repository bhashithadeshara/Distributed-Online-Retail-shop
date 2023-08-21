package org.example;

import ds.tutorial.communication.grpc.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class AddToShoppingCardServiceClient {

    private ManagedChannel channel = null;
    addToShoppingCardServiceGrpc.addToShoppingCardServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public AddToShoppingCardServiceClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" +
                port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = addToShoppingCardServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter cart ID, item quantity to add to the cart :");
            String input[] = userInput.nextLine().trim().split(",");
            String cardId = input[0];
            double quantity = Double.parseDouble(input[1]);
            System.out.println("Requesting server to set the quantity to " + quantity + " for " + cardId.toString());
            AddToShoppingCardRequest request = AddToShoppingCardRequest
                    .newBuilder()
                    .setCardId(cardId)
                    .setValue(quantity)
                    .setIsSentByPrimary(false)
                    .build();
            AddToShoppingCardResponse response = clientStub.addToShoppingCard(request);
            System.out.printf("Transaction Status " + (response.getStatus() ? "Sucessful" : "Failed"));
            Thread.sleep(1000);
        }
    }
}
