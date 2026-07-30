package DesignPatterns.structural.facade;

public class MorningRoutineFacade {
    private final Alarm alarm;
    private final CoffeeMachine coffeeMachine;
    private final Shower shower;
    private final Bag bag;

    public MorningRoutineFacade() {
        this.alarm = new Alarm();
        this.coffeeMachine = new CoffeeMachine();
        this.shower = new Shower();
        this.bag = new Bag();
    }

    public void getReadyForOffice() {
        alarm.turnOff();
        coffeeMachine.brewCoffee();
        shower.start();
        bag.packEssentials();
    }
}
