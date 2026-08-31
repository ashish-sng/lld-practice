package DesignPatterns.structural.flyweight;

public class MapPin {
    private final double latitude;
    private final double longitude;
    private final MapIcon icon;
    private final String placeName;

    public MapPin(double latitude, double longitude, MapIcon icon, String placeName) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.icon = icon;
        this.placeName = placeName;
    }

    public void drawOnMap() {
        icon.draw(latitude, longitude, placeName);
    }
}
