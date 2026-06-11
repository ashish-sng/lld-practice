package SolidPrinciples.OCP.violates;


public class Main {
    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment("CREDIT_CARD");
        paymentProcessor.processPayment("PAYPAL");
    }

}
