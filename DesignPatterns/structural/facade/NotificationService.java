package DesignPatterns.structural.facade;

public class NotificationService {
    public void sendConfirmation(String email, String trackingId) {
        System.out.println("Sending confirmation email for trackingId: " + trackingId + " to email: " + email);
    }
}
