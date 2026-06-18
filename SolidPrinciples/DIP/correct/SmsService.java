package SolidPrinciples.DIP.correct;

public class SmsService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
