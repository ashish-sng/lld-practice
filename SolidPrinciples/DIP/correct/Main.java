package SolidPrinciples.DIP.correct;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService =
                new EmailService();

        NotificationService notificationServiceSms =
                new SmsService();

        NotificationManager emailManager =
                new NotificationManager(
                        notificationService);

        NotificationManager smsManager =
                new NotificationManager(
                        notificationServiceSms);

        emailManager.send("Welcome");

        smsManager.send("Welcome");
    }
}
