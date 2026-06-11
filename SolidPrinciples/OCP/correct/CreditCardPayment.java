package SolidPrinciples.OCP.correct;

public class CreditCardPayment implements PaymentMethod {

    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card Payment");
    }
}