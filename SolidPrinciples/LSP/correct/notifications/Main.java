package SolidPrinciples.LSP.correct.notifications;

public class Main {

    public static void sendNotification(
            SendableNotification notification) {

        notification.send();
    }

    public static void main(String[] args) {

        sendNotification(
                new EmailNotification("Hello"));

        sendNotification(
                new PushNotification("Hello"));
    }
}
