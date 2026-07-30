package DesignPatterns.structural.decorator;

public class HoneyDecorator extends BeverageDecorator {
    public HoneyDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", honey";
    }

    @Override
    public int getCost() {
        return beverage.getCost() + 10;
    }
}
