package DesignPatterns.structural.decorator;

public abstract class NotificationDecorator implements NotificationService {
    protected final NotificationService wrappedNotifier;

    protected NotificationDecorator(NotificationService wrappedNotifier) {
        this.wrappedNotifier = wrappedNotifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
    
}
