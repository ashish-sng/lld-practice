package DesignPatterns.behavioural.template_method;

public class Main {
    public static void main(String[] args) {
        HotDrink tea = new Tea();
        tea.prepare();

        System.out.println();

        HotDrink coffee = new Coffee();
        coffee.prepare();
    }
}
