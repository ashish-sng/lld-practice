package DesignPatterns.creational.abstract_factory.SinghBurger;
import DesignPatterns.creational.abstract_factory.items.Burger;

public class StandardBurger implements Burger{
    @Override
    public void createBurger() {
        System.out.println("Preparing Standard Burger");
    }
}
