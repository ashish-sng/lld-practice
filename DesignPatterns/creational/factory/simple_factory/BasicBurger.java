package DesignPatterns.creational.factory.simple_factory;

public class BasicBurger implements Burger {
    @Override 
    public void prepareBurger() {
        System.out.println("Preparing Basic Burger");
    }
}
