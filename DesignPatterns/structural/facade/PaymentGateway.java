package DesignPatterns.structural.facade;

public class PaymentGateway {
    public boolean processPayment(String accountId, double amount) {
        System.out.println("--> Processing payment of " + amount + " for accountId: " + accountId);
        return true;
    }
}
