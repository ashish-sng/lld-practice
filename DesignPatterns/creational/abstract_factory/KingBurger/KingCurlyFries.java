package DesignPatterns.creational.abstract_factory.KingBurger;

import DesignPatterns.creational.abstract_factory.items.Side;

public class KingCurlyFries extends Side {
    @Override
    public void fry() {
        System.out.println("Frying Classic Curly Fries");
    }
}
