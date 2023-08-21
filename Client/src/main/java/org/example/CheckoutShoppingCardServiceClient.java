package org.example;

import ds.tutorial.communication.grpc.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class CheckoutShoppingCardServiceClient {

    private ManagedChannel channel = null;

    CheckoutShoppingCardServiceGrpc.CheckoutShoppingCardServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public CheckoutShoppingCardServiceClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" +
                port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = CheckoutShoppingCardServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter card ID, and the quantity to checkout :");
            String input[] = userInput.nextLine().trim().split(",");
            String cardId = input[0];
            double quantity = Double.parseDouble(input[1]);
            System.out.println("Requesting server to checkout quantity to " + quantity + " for " + cardId.toString());
            CheckoutShoppingCardRequest request = CheckoutShoppingCardRequest
                    .newBuilder()
                    .setCardId(cardId)
                    .setValue(quantity)
                    .setIsSentByPrimary(false)
                    .build();
            CheckoutShoppingCardResponse response = clientStub.checkoutShoppingCard(request);
            System.out.printf("Transaction Status " + (response.getStatus() ? "Sucessful" : "Failed"));
            Thread.sleep(1000);
        }
    }
}
