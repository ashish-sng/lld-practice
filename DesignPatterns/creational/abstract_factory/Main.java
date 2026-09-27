package DesignPatterns.creational.abstract_factory;

import DesignPatterns.creational.abstract_factory.items.Drink;
import DesignPatterns.creational.abstract_factory.items.Side;
import DesignPatterns.creational.abstract_factory.items.Burger;

public class Main {
     // Client method: depends only on abstractions
     public static void orderCombo(BurgerFactory factory) {
         Burger burger = factory.prepareBurger(BurgerType.BASIC);
         Drink drink = factory.createDrink();
         Side side = factory.createSide();
         burger.createBurger();
         drink.pour();
         side.fry();
         System.out.println("--- Combo served! ---\n");
     }
    
    public static void main(String[] args) {
        BurgerFactory singhFactory = new SinghBurgerShop();
        singhFactory.prepareBurger(BurgerType.BASIC).createBurger();
        singhFactory.prepareBurger(BurgerType.STANDARD).createBurger();
        singhFactory.prepareBurger(BurgerType.PREMIUM).createBurger();

        orderCombo(singhFactory);

        BurgerFactory kingFactory = new KingBurgerShop();
        kingFactory.prepareBurger(BurgerType.BASIC).createBurger();
        kingFactory.prepareBurger(BurgerType.STANDARD).createBurger();;
        kingFactory.prepareBurger(BurgerType.PREMIUM).createBurger();;
    }
}
