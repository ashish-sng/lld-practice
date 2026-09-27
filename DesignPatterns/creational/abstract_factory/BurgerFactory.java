package DesignPatterns.creational.abstract_factory;

import DesignPatterns.creational.abstract_factory.items.Burger;
import DesignPatterns.creational.abstract_factory.items.Drink;
import DesignPatterns.creational.abstract_factory.items.Side;

enum BurgerType {
    BASIC, STANDARD, PREMIUM
}

public abstract class BurgerFactory {
    public abstract Burger prepareBurger(BurgerType type);
    
    public abstract Drink createDrink();

    public abstract Side createSide();
}
