package DesignPatterns.structural.decorator;

public class SlackNotifierDecorator extends NotificationDecorator {
    public SlackNotifierDecorator(NotificationService wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SLACK message: " + message);
    }
}
