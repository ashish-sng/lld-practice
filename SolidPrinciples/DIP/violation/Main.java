package SolidPrinciples.DIP.violation;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationsManager = new NotificationManager();

        notificationsManager.send("Welcome");
    }
}

// Now if we want to add a new notification type i.e SMS, we would need to modify the NotificationManager class, which violates the DIP.
