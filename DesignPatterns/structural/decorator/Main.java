package DesignPatterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        NotificationService notifier = new EmailNotifier();
        System.out.println("Basic notification:");
        notifier.send("Order shipped successfully");

        System.out.println();

        NotificationService highPriorityNotifier =
                new SmsNotifierDecorator(
                        new SlackNotifierDecorator(
                                new EmailNotifier()
                        )
                );

        System.out.println("High priority notification:");
        highPriorityNotifier.send("Payment failed for order #123");


        System.out.println();

        NotificationService allChannelNotifier =
                new WhatsappNotifierDecorator(
                        new SmsNotifierDecorator(
                                new SlackNotifierDecorator(
                                        new EmailNotifier()
                                )
                        )
                );

        System.out.println("Critical notification:");
        allChannelNotifier.send("Production server CPU is above 95%");
    }
}
