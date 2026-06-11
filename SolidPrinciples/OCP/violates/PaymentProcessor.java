package SolidPrinciples.OCP.violates;

public class PaymentProcessor {

    public void processPayment(String paymentMethod) {

        if ("CREDIT_CARD".equals(paymentMethod)) {
            System.out.println("Processing Credit Card Payment");
        } else if ("PAYPAL".equals(paymentMethod)) {
            System.out.println("Processing PayPal Payment");
        }
    }
}