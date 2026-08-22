package DesignPatterns.structural.bridge;

public abstract class Alert {
    protected AlertChannel channel;

    public Alert(AlertChannel alertChannel) {
        this.channel = alertChannel;
    }

    public abstract void notify(String target, String details);
}
