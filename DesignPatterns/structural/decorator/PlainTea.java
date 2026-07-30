package DesignPatterns.structural.decorator;

public class PlainTea implements Beverage {
    @Override
    public String getDescription() {
        return "Plain tea";
    }

    @Override
    public int getCost() {
        return 20;
    }
}
