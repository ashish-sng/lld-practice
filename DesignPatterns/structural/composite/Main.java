package DesignPatterns.structural.composite;

public class Main {
    public static void main(String[] args) {
        Packable tshirt = new ClothingItem("T-Shirt", 200);
        Packable jeans = new ClothingItem("Jeans", 700);
        Packable jacket = new ClothingItem("Jacket", 900);

        TravelBag toiletriesPouch = new TravelBag("Toiletries pouch");
        toiletriesPouch.add(new ClothingItem("Hand towel", 150));
        toiletriesPouch.add(new ClothingItem("Socks", 80));

        TravelBag weekendBag = new TravelBag("Weekend travel bag");
        weekendBag.add(tshirt);
        weekendBag.add(jeans);
        weekendBag.add(jacket);
        weekendBag.add(toiletriesPouch);

        weekendBag.showDetails();
        System.out.println("Total packed weight: " + weekendBag.getWeight() + " grams");
    }
}
