package DesignPatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class LaundryMachine implements Subject {
    private final String machineId;
    private final List<Observer> observers = new ArrayList<>();
    private String statusMessage;

    public LaundryMachine(String machineId) {
        this.machineId = machineId;
    }

    public void setStatus(String statusMessage) {
        this.statusMessage = statusMessage;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(machineId, statusMessage);
        }
    }
}
