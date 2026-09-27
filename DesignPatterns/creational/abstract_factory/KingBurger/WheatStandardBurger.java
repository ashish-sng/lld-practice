package DesignPatterns.creational.abstract_factory.KingBurger;
import DesignPatterns.creational.abstract_factory.items.Burger;

public class WheatStandardBurger implements Burger {
    @Override
    public void createBurger() {
        System.out.println("Creating wheat standard burger");
    }
}
