package DesignPatterns.behavioural.template_method;

abstract public class HotDrink {
    // This is Template method, It defaines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
    public final void prepare() {
        boilWater();
        addMainIngredient();
        pourInCup();
        addExtras();
    };

    private void boilWater() {
        System.out.println("Boiling water");
    }

    protected abstract void addMainIngredient();

    private void pourInCup() {
        System.out.println("Pouring in cup");
    }

    abstract void addExtras();
}
