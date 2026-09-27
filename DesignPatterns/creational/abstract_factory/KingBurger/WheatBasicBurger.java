package DesignPatterns.creational.abstract_factory.KingBurger;
import DesignPatterns.creational.abstract_factory.items.Burger;

public class WheatBasicBurger implements Burger {
    @Override 
    public void createBurger() {
        System.out.println("Creating wheat basic burger");
    }
}
