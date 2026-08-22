package DesignPatterns.structural.bridge;

public interface AlertChannel {
    void send(String alertType, String target, String message);
}
