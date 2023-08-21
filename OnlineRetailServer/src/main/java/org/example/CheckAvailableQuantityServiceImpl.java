package org.example;

import ds.tutorial.communication.grpc.generated.CheckAvailableQuantityRequest;
import ds.tutorial.communication.grpc.generated.CheckAvailableQuantityResponse;
import ds.tutorial.communication.grpc.generated.CheckAvailableQuantityServiceGrpc;
import io.grpc.stub.StreamObserver;

public class CheckAvailableQuantityServiceImpl extends CheckAvailableQuantityServiceGrpc.CheckAvailableQuantityServiceImplBase {

    private RetailServer server;

    @Override
    public void checkAvailableQuantity(CheckAvailableQuantityRequest request, StreamObserver<CheckAvailableQuantityResponse> responseObserver) {

        System.out.println("Request received..");

        String itemId = request.getItemId();
        double quantity = getAvailableQuantity(itemId);
        CheckAvailableQuantityResponse response = CheckAvailableQuantityResponse
                .newBuilder()
                .setAvailableQuantity(quantity)
                .build();
        System.out.println("Responding, available quantity for item " + itemId +" is "+quantity);
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    public CheckAvailableQuantityServiceImpl(RetailServer server){
        this.server = server;
    }



    private double getAvailableQuantity(String itemId) {
        return server.getAvailableQuantity(itemId);
    }
}
