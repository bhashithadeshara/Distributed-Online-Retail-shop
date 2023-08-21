package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String host = args[0];
        int port = Integer.parseInt(args[1].trim());
        String operation = args[2];

        if (args.length != 3) {
            System.out.println("Usage CheckBalanceServiceClient <host> <port> <s(et)|c(heck)");
            System.exit(1);
        }

        if ("s".equals(operation)) {
            UpdateQuantityServiceClient client = new UpdateQuantityServiceClient(host, port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        }else if("c".equals(operation)){
            CheckAvailableQuantityClient client = new CheckAvailableQuantityClient(host,
                    port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        }else if("a".equals(operation)){
            AddToShoppingCardServiceClient client = new AddToShoppingCardServiceClient(host,port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        }else{
            CheckoutShoppingCardServiceClient client = new CheckoutShoppingCardServiceClient(host,port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        }
    }
}