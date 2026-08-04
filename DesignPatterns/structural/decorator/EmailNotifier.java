package DesignPatterns.structural.decorator;

public class EmailNotifier implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
