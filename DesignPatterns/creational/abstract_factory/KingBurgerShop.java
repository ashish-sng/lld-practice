package DesignPatterns.creational.abstract_factory;
import DesignPatterns.creational.abstract_factory.KingBurger.KingCoke;
import DesignPatterns.creational.abstract_factory.KingBurger.KingCurlyFries;
import DesignPatterns.creational.abstract_factory.KingBurger.WheatBasicBurger;
import DesignPatterns.creational.abstract_factory.KingBurger.WheatPremiumBurger;
import DesignPatterns.creational.abstract_factory.KingBurger.WheatStandardBurger;
import DesignPatterns.creational.abstract_factory.items.Burger;
import DesignPatterns.creational.abstract_factory.items.Drink;
import DesignPatterns.creational.abstract_factory.items.Side;

public class KingBurgerShop extends BurgerFactory {
    @Override 
    public Burger prepareBurger(BurgerType type) {
        if (type == BurgerType.BASIC) {
            return new WheatBasicBurger();
        } else if (type == BurgerType.STANDARD) {
            return new WheatStandardBurger();
        } else if (type == BurgerType.PREMIUM) {
            return new WheatPremiumBurger();
        }

        throw new IllegalArgumentException("Burger Type not suppoerted: " + type);
    }

    @Override
    public Drink createDrink() {
        return new KingCoke();
    }
    @Override
    public Side createSide() {
        return new KingCurlyFries();
    }
}
