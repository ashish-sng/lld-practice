package DesignPatterns.structural.flyweight;

public class MapIcon {
    private final String category;
    private final String iconImage;
    private final String color;

    public MapIcon(String category, String iconImage, String color) {
        this.category = category;
        this.iconImage = iconImage;
        this.color = color;
    }

    public void draw(double lat, double lng, String placeName) {
        System.out.println("[CATEGORY: " + category + "] Drawing " + color + " " + iconImage + " at " + lat + ", " + lng + " (" + placeName + ")");
    }
}
