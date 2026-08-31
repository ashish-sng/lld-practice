package DesignPatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MapPin> pins = new ArrayList<>();
        pins.add(new MapPin(10, 20, MapIconFactory.getIcon("Restaurant", "fork_spoon", "RED"), "Restaurant A"));
        pins.add(new MapPin(30, 40, MapIconFactory.getIcon("Hotel", "bed", "BLUE"), "Hotel A"));
        pins.add(new MapPin(50, 60, MapIconFactory.getIcon("Restaurant", "fork_spoon", "GREEN"), "Restaurant B"));
        pins.add(new MapPin(70, 80, MapIconFactory.getIcon("Hotel", "bed", "YELLOW"), "Hotel B"));

        // Repitition of same category, color, image with different extrinsic attributes
        pins.add(new MapPin(10, 60, MapIconFactory.getIcon("Restaurant", "fork_spoon", "GREEN"), "Restaurant C"));
        pins.add(new MapPin(410, 120, MapIconFactory.getIcon("Hotel", "bed", "BLUE"), "Hotel F"));
        pins.add(new MapPin(90, 120, MapIconFactory.getIcon("Restaurant", "fork_spoon", "RED"), "Restaurant E"));
        pins.add(new MapPin(70, 80, MapIconFactory.getIcon("Hotel", "bed", "YELLOW"), "Hotel D"));

        for (MapPin pin : pins) {
            pin.drawOnMap();
        }

        System.out.println("\n--- FLYWEIGHT PROOF ---");
        System.out.println("Total MapPin objects created on map: " + pins.size());
        System.out.println("Total MapIcon Flyweight instances in RAM: " + MapIconFactory.getCacheSize());

    }
}
