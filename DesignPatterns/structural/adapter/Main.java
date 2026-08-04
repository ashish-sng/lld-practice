package DesignPatterns.structural.adapter;

public class Main {
    public static void main(String[] args) {
        RazorpayApi razorpayApi = new RazorpayApi();
        PaymentGateway paymentGateway = new RazorpayAdapter(razorpayApi);

        CheckoutService checkoutService = new CheckoutService(paymentGateway);
        checkoutService.checkout(100); // Checkout for Rs. 100
    }
}
