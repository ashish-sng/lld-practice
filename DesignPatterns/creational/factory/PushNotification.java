package DesignPatterns.creational.factory;

public class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending Push Notifications: " + message);
    }
}
