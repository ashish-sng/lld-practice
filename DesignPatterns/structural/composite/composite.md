# Composite Pattern in This Example

This example uses the Composite pattern for a very practical daily-life situation:

- packing clothes and small pouches inside a travel bag

Sometimes we deal with a single item like:

- a T-shirt
- jeans
- a jacket

Sometimes we deal with a group item like:

- a toiletries pouch
- a weekend travel bag

The Composite pattern lets us treat both single items and grouped items in the same way.

## Classes and their roles

- `Packable`
  - Common interface for both single items and grouped items.
  - It defines:
    - `showDetails()`
    - `getWeight()`

- `ClothingItem`
  - This is the leaf object.
  - It represents a single packable item.

- `TravelBag`
  - This is the composite object.
  - It can store many `Packable` objects.
  - Those objects can be:
    - single items
    - other bags or grouped items

## How it works

In `Main`, we create leaf objects like:

```java
Packable tshirt = new ClothingItem("T-Shirt", 200);
Packable jeans = new ClothingItem("Jeans", 700);
```

Then we create a smaller grouped object:

```java
TravelBag toiletriesPouch = new TravelBag("Toiletries pouch");
toiletriesPouch.add(new ClothingItem("Hand towel", 150));
toiletriesPouch.add(new ClothingItem("Socks", 80));
```

Then we create the main bag:

```java
TravelBag weekendBag = new TravelBag("Weekend travel bag");
weekendBag.add(tshirt);
weekendBag.add(jeans);
weekendBag.add(jacket);
weekendBag.add(toiletriesPouch);
```

Notice something important:

- `weekendBag` stores both simple objects and another composite object

That is the core idea of Composite.

## How the common treatment works

When this runs:

```java
weekendBag.showDetails();
```

the bag loops through every `Packable` item and calls:

```java
item.showDetails();
```

It does not care whether that item is:

- a single `ClothingItem`
- another `TravelBag`

The same idea applies to:

```java
weekendBag.getWeight();
```

If the object is a leaf, it returns its own weight.
If the object is a composite, it sums the weight of everything inside it.

## Why this is useful

Without Composite, client code would need special handling like:

- if item is a single object, do one thing
- if item is a bag, loop through children separately

That makes the code more complex.

With Composite:

- leaf and group objects share the same interface
- client code becomes simpler
- nested structures become easier to manage

## Why this example feels practical

People organize many things in this nested way:

- bags inside bags
- folders inside folders
- gift boxes inside bigger boxes
- grocery baskets with grouped items

The Composite pattern is useful whenever individual objects and collections of objects should be treated uniformly.
