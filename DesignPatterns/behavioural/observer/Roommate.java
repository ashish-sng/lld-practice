package DesignPatterns.behavioural.observer;

public class Roommate implements Observer {
    private final String name;

    public Roommate(String name) {
        this.name = name;
    }

    @Override
    public void update(String machineId, String statusMessage) {
        System.out.println(name + " got update from " + machineId + ": " + statusMessage);
    }
}
