package DesignPatterns.structural.bridge;

public class PagerDutyAlertChannel implements AlertChannel {
    @Override
    public void send(String alertType, String target, String message) {
        System.out.println("Triggering " + alertType + " incident in PagerDuty for service: " + target);
        System.out.println("Payload: " + message);
    } 
}
