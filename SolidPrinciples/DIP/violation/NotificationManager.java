package SolidPrinciples.DIP.violation;

public class NotificationManager {
    private EmailService emailService = new EmailService();

    public void send(String message) {
        emailService.sendEmail(message);
    }
}
