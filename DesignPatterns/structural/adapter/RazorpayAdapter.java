package DesignPatterns.structural.adapter;

public class RazorpayAdapter implements PaymentGateway {
    private final RazorpayApi razorpayApi;

    public RazorpayAdapter(RazorpayApi razorpayApi) {
        this.razorpayApi = razorpayApi;
    }

    @Override
    public void pay(int amountInRupees) {
        int amountInPaise = amountInRupees * 100;
        razorpayApi.makePaymentInPaise(amountInPaise);
        
    }
    
}
