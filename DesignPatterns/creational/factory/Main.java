package DesignPatterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        Notification emailNotification = NotificationFactory.createNotification("EMAIL");
        emailNotification.send("Hello via Email!");

        Notification smsNotification = NotificationFactory.createNotification("SMS");
        smsNotification.send("Hello via SMS!");

        Notification pushNotification = NotificationFactory.createNotification("PUSH");
        pushNotification.send("Hello via Push Notification!");
    }
}
