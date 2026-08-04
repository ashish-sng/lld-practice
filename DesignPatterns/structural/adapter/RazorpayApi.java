package DesignPatterns.structural.adapter;

public class RazorpayApi {
    public void makePaymentInPaise(int amountInPaise) {
        System.out.println("RazorPay processed payment of " + amountInPaise + " paise");
    }
}
