package DesignPatterns.structural.facade;

public class Main {
    public static void main(String[] args) {
        OrderProcessingFacade orderProcessingFacade = new OrderProcessingFacade();
        orderProcessingFacade.placeOrder("PROD-101", 2, 499.99, "ACC-987", "123 Main St", "ashishsingh.1899@gmail.com");
    }
}
