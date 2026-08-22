package DesignPatterns.structural.bridge;

public class SecurityAlert extends Alert {

    public SecurityAlert(AlertChannel alertChannel) {
        super(alertChannel);
    }

    @Override
    public void notify(String target, String details) {
        String message = "Critical security issue: " + details;
        channel.send("Security", target, message);
    }
    
}
