package DesignPatterns.creational.factory.simple_factory;

public class PremiumBurger implements Burger {
    @Override 
    public void prepareBurger() {
        System.out.println("Preparing Premium Burger");
    }
}
