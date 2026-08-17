package DesignPatterns.structural.facade;

public class ShippingService {
    public String scheduleDelivery(String productId, int quantity, String Address){
        System.out.println("Scheduling delivery of " + quantity + " units of product: " + productId + " to address: " + Address);
        return productId + "-TRACK-123-" + quantity;
    }
}
