package DesignPatterns.structural.bridge;

public class SlackAlertChannel implements AlertChannel {
    @Override
    public void send(String alertType, String target, String message) {
        System.out.println("Sending " + alertType + " alert to Slack channel: " + target);
        System.out.println("Message: " + message);
    } 
}
