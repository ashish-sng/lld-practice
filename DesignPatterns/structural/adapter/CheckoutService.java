package DesignPatterns.structural.adapter;

public class CheckoutService {
    private final PaymentGateway paymentGateway;

    CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(int amountInRupees) {
        System.out.println("Starting checkout for Rs. " + amountInRupees);
        paymentGateway.pay(amountInRupees);
        System.out.println("Checkout completed for Rs. " + amountInRupees);
    }
}
