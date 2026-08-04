package DesignPatterns.structural.decorator;

public class WhatsappNotifierDecorator extends NotificationDecorator {
    public WhatsappNotifierDecorator(NotificationService wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending WHATSAPP message: " + message);
    }
}
