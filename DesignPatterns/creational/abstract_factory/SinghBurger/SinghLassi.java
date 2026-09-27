package DesignPatterns.creational.abstract_factory.SinghBurger;

import DesignPatterns.creational.abstract_factory.items.Drink;

public class SinghLassi extends Drink{
    @Override 
    public void pour() {
        System.out.println("Pouring Lassi from Singh");
    }
}
