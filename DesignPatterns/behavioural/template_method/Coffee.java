package DesignPatterns.behavioural.template_method;

class Coffee extends HotDrink {
    @Override
    protected void addMainIngredient() {
        System.out.println("Adding coffee powder");
    }

    @Override
    protected void addExtras() {
        System.out.println("Adding sugar and milk");
    }
}
