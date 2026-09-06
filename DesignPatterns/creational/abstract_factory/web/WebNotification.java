package DesignPatterns.creational.abstract_factory.web;

import DesignPatterns.creational.abstract_factory.Notification;

public class WebNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Web Notifications: " + message);
    }
}
