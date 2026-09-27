package DesignPatterns.creational.abstract_factory.SinghBurger;
import DesignPatterns.creational.abstract_factory.items.Burger;

public class PremiumBurger implements Burger {
    @Override
    public void createBurger() {
        System.out.println("Preparing Premium Burger");
    }
}
