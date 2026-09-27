package DesignPatterns.creational.abstract_factory.KingBurger;

import DesignPatterns.creational.abstract_factory.items.Drink;

public class KingLassi extends Drink {
    @Override 
    public void pour() {
        System.out.println("Pouring King Lassi");
    }
}
