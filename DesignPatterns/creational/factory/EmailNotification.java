package DesignPatterns.creational.factory;

public class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending Email Notifications: " + message);
    }
}
