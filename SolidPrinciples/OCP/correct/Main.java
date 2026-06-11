package SolidPrinciples.OCP.correct;

public class Main {
    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment(
                new CreditCardPayment());

        paymentProcessor.processPayment(
                new PayPalPayment());

        paymentProcessor.processPayment(
                new UpiPayment());
    }
}
