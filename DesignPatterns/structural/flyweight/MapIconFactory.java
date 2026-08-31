package DesignPatterns.structural.flyweight;

import java.util.*;

public class MapIconFactory {
    private static final Map<String, MapIcon> iconCache = new HashMap<>();

    public static MapIcon getIcon(String category, String iconImage, String color) {
        String key = category + iconImage + color;
        if (!iconCache.containsKey(key)) {
            System.out.println("Creating new icon for: " + key);
            iconCache.put(key, new MapIcon(category, iconImage, color));
        }
        System.out.println("Fetching icon from cache for: " + key);
        return iconCache.get(key);
    }

    public static int getCacheSize() {
        return iconCache.size();
    }
}
