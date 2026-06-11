package SolidPrinciples.OCP.correct;

public class UpiPayment implements PaymentMethod {

    public void processPayment() {
        System.out.println("Processing UPI Payment");
    }
}
