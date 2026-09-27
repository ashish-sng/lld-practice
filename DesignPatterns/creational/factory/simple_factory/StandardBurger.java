package DesignPatterns.creational.factory.simple_factory;

public class StandardBurger implements Burger {
    @Override 
    public void prepareBurger() {
        System.out.println("Preparing Standard Burger");
    }
}
