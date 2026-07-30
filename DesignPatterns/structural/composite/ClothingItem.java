package DesignPatterns.structural.composite;

public class ClothingItem implements Packable {
    private final String name;
    private final int weight;

    public ClothingItem(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public void showDetails() {
        System.out.println(name + " - " + weight + " grams");
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
