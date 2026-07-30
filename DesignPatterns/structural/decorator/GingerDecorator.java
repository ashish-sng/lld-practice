package DesignPatterns.structural.decorator;

public class GingerDecorator extends BeverageDecorator {
    public GingerDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", ginger";
    }

    @Override
    public int getCost() {
        return beverage.getCost() + 5;
    }
}
