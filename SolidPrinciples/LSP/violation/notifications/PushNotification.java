package SolidPrinciples.LSP.violation.notifications;

public class PushNotification
        extends Notification
        implements SendableNotification {

    public PushNotification(String message) {
        super(message);
    }

    @Override
    public void send() {
        System.out.println("Sending Push Notification: " + message);
    }
}
