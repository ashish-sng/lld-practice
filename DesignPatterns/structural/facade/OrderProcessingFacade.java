package DesignPatterns.structural.facade;

public class OrderProcessingFacade {
    private final InventoryService inventoryService;
    private final PaymentGateway paymentGateway;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderProcessingFacade() {
        this.inventoryService = new InventoryService();
        this.paymentGateway = new PaymentGateway();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public boolean placeOrder(String productId, int quantity, double amount, String accountId, String address,
            String email) {
        boolean stockReserved = inventoryService.checkStock(productId, quantity);
        if (!stockReserved) {
            System.out.println("Stock not available for product: " + productId);
            return false;
        }
        inventoryService.reserveStock(productId, quantity);
        boolean paymentProcessed = paymentGateway.processPayment(accountId, amount);
        if (!paymentProcessed) {
            System.out.println("Payment failed for accountId: " + accountId);
            return false;
        }
        String trackingId = shippingService.scheduleDelivery(productId, quantity, address);
        notificationService.sendConfirmation(email, trackingId);
        return true;
    }

}
