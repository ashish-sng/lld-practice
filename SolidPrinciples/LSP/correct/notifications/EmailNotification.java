package SolidPrinciples.LSP.correct.notifications;

public class EmailNotification
        extends Notification
        implements SendableNotification {

    public EmailNotification(String message) {
        super(message);
    }

    @Override
    public void send() {
        System.out.println("Sending Email: " + message);
    }
}
