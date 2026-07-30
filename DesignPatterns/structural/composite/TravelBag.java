package DesignPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class TravelBag implements Packable {
    private final String name;
    private final List<Packable> items = new ArrayList<>();

    public TravelBag(String name) {
        this.name = name;
    }

    public void add(Packable packable) {
        items.add(packable);
    }

    @Override
    public void showDetails() {
        System.out.println(name + " contains:");
        for (Packable item : items) {
            item.showDetails();
        }
    }

    @Override
    public int getWeight() {
        int totalWeight = 0;
        for (Packable item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}
