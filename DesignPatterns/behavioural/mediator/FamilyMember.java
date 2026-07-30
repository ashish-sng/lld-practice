package DesignPatterns.behavioural.mediator;

public abstract class FamilyMember {
    protected final TripMediator mediator;
    protected final String name;

    public FamilyMember(TripMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public void send(String message) {
        mediator.sendUpdate(message, this);
    }

    public void receive(String message) {
        System.out.println(name + " received update -> " + message);
    }

    public String getName() {
        return name;
    }
}
