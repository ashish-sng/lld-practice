package DesignPatterns.creational.abstract_factory;

import DesignPatterns.creational.abstract_factory.SinghBurger.PremiumBurger;
import DesignPatterns.creational.abstract_factory.SinghBurger.SinghCurlyFries;
import DesignPatterns.creational.abstract_factory.SinghBurger.SinghLassi;
import DesignPatterns.creational.abstract_factory.SinghBurger.StandardBurger;
import DesignPatterns.creational.abstract_factory.items.Burger;
import DesignPatterns.creational.abstract_factory.items.Drink;
import DesignPatterns.creational.abstract_factory.items.Side;
import DesignPatterns.creational.abstract_factory.SinghBurger.BasicBurger;

public class SinghBurgerShop extends BurgerFactory {
    @Override 
    public Burger prepareBurger(BurgerType type) {
        if (type == BurgerType.BASIC) {
            return new BasicBurger();
        } else if (type == BurgerType.STANDARD) {
            return new StandardBurger();
        } else if (type == BurgerType.PREMIUM) {
            return new PremiumBurger();
        }

        throw new IllegalArgumentException("Type passed is incorrect : " + type);
    }
    
    @Override
    public Drink createDrink() {
        return new SinghLassi();
    }
    @Override
    public Side createSide() {
        return new SinghCurlyFries();
    }
}
