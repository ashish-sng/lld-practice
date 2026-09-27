package DesignPatterns.creational.abstract_factory.SinghBurger;

import DesignPatterns.creational.abstract_factory.items.Side;

public class SinghCurlyFries extends Side {
    @Override 
    public void fry() {
        System.out.println("Frying curly fries from Singh");
    }
}
