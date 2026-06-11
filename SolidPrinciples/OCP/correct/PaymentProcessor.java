package SolidPrinciples.OCP.correct;

public class PaymentProcessor {

    public void processPayment(PaymentMethod paymentMethod) {
        paymentMethod.processPayment();
    }
}
