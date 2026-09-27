package DesignPatterns.creational.factory.simple_factory;

public class Main {
    public static void main(String[] args) {
        BurgerFactory burgerFactory = new BurgerFactory();

        Burger breakfast = burgerFactory.createBurger(BurgerType.BASIC);
        breakfast.prepareBurger();

        Burger lunch = burgerFactory.createBurger(BurgerType.PREMIUM);
        lunch.prepareBurger();
    }
}
