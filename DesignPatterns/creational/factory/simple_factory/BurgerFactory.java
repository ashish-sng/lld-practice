package DesignPatterns.creational.factory.simple_factory;

enum BurgerType {
    BASIC, STANDARD, PREMIUM
}

public class BurgerFactory {
    public Burger createBurger(BurgerType type) {
        if (type == BurgerType.BASIC) {
            return new BasicBurger();
        } else if (type == BurgerType.STANDARD) {
            return new StandardBurger();
        } else if (type == BurgerType.PREMIUM) {
            return new PremiumBurger();
        }

        throw new IllegalArgumentException("Burger Type not suppoerted: " + type);
    }
}
