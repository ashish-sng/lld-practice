package DesignPatterns.structural.decorator;

public class SmsNotifierDecorator extends NotificationDecorator {
    public SmsNotifierDecorator(NotificationService wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}
