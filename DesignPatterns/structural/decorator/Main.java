package DesignPatterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Beverage eveningTea = new PlainTea();
        eveningTea = new GingerDecorator(eveningTea);
        eveningTea = new HoneyDecorator(eveningTea);
        eveningTea = new LemonDecorator(eveningTea);

        System.out.println("Tea order: " + eveningTea.getDescription());
        System.out.println("Total cost: " + eveningTea.getCost());
    }
}
