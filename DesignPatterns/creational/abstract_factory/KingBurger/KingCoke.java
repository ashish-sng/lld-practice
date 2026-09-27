package DesignPatterns.creational.abstract_factory.KingBurger;

import DesignPatterns.creational.abstract_factory.items.Drink;

public class KingCoke extends Drink {
    @Override 
    public void pour() {
        System.out.println("Pouring Kig coke");
    }
}
