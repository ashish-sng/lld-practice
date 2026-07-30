package DesignPatterns.structural.decorator;

public class LemonDecorator extends BeverageDecorator {
    public LemonDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", lemon";
    }

    @Override
    public int getCost() {
        return beverage.getCost() + 7;
    }
}
