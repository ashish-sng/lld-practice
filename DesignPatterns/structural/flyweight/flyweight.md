# Flyweight Pattern: Google Maps Pin Marker Engine

The **Flyweight Pattern** reduces memory usage by sharing common, heavy data (**Intrinsic State**) across thousands of light objects that hold only context-specific data (**Extrinsic State**).

---

## 🎯 The Real-World Problem (Intuitive & Easy to Explain!)

Think of **Google Maps** showing **50,000 restaurant pins** and **20,000 gas station pins** across a city:

- Every pin has a category icon image (`restaurant_icon.png`, `gas_station_icon.png`), pin color, and category description.
- Every pin also has a unique location on the map `(latitude, longitude)` and place name (`"Dominos Pizza", "Shell Gas"`).

### ❌ Without Flyweight
If all 70,000 map pins load their own image texture and icon data into memory:
- 70,000 loaded image objects = Hundreds of Megabytes of wasted RAM.

---

## 💡 The Flyweight Solution

```
                 MapIconFactory
                       │
             Map<String, MapIcon>
                       │
            ┌──────────┴──────────┐
            ▼                     ▼
     "RESTAURANT"           "GAS_STATION"    (Flyweights - Intrinsic State)
  (Red Pin, Fork Icon)   (Green Pin, Gas Icon) Shared by thousands of pins!
            ▲                     ▲
      ┌─────┴─────┐         ┌─────┴─────┐
      │           │         │           │
    Pin #1      Pin #2    Pin #3      Pin #4 (Contexts - Extrinsic State)
  (Lat/Lng)   (Lat/Lng) (Lat/Lng)   (Lat/Lng) Holds unique coordinates only!
```

- **Intrinsic State (Flyweight)**: `MapIcon`
  - Shared, heavy, immutable data: `category`, `iconImage`, `color`.
  - There are only 3 or 4 `MapIcon` instances in RAM for the entire city!

- **Extrinsic State (Context)**: `MapPin`
  - Unique data per pin: `latitude`, `longitude`, `placeName`.
  - Points to the shared `MapIcon` instance.

---

## 🛠️ Guided Step-by-Step Practice

### 1. Flyweight Class (`MapIcon.java`)
- Stores `category`, `iconImage`, `color`.
- `draw(double lat, double lng, String placeName)`: Renders pin at location.

### 2. Flyweight Factory (`MapIconFactory.java`)
- Keeps `Map<String, MapIcon> iconCache`.
- `getIcon(category, iconImage, color)`: Returns cached icon or creates a new one.

### 3. Context Class (`MapPin.java`)
- Stores `latitude`, `longitude`, `placeName`, and reference to shared `MapIcon`.
- `drawOnMap()` $\rightarrow$ delegates to `icon.draw(lat, lng, placeName)`.
