package DesignPatterns.behavioural.template_method;

public class Tea extends HotDrink {
    @Override
    protected void addMainIngredient() {
        System.out.println("Adding tea leaves");
    }

    @Override
    void addExtras() {
        System.out.println("Adding sugar and milk");
    }
}
