package DesignPatterns.creational.factory;

public class SmsNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending SMS Notifications: " + message);
    }
    
}
