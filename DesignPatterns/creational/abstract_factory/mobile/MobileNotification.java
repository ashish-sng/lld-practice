package DesignPatterns.creational.abstract_factory.mobile;
import DesignPatterns.creational.abstract_factory.Notification;

public class MobileNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Mobile Notifications: " + message);
    }
}
