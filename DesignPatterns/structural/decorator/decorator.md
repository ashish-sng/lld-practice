# Decorator Pattern in This Example

This example uses the Decorator pattern for a relatable situation:

- customizing a cup of tea at home

You may start with plain tea and then add:

- ginger
- honey
- lemon

Each add-on changes the final drink without needing a brand-new class for every possible combination.

## Classes and their roles

- `Beverage`
  - Common interface for all drink objects.

- `PlainTea`
  - The base object.

- `BeverageDecorator`
  - Base decorator class that stores another `Beverage`.

- `GingerDecorator`
- `HoneyDecorator`
- `LemonDecorator`
  - Concrete decorators.
  - Each one adds its own description and cost.

## How it works

In `Main`, we start with:

```java
Beverage eveningTea = new PlainTea();
```

Then we wrap it step by step:

```java
eveningTea = new GingerDecorator(eveningTea);
eveningTea = new HoneyDecorator(eveningTea);
eveningTea = new LemonDecorator(eveningTea);
```

Each wrapper adds new behavior on top of the previous object.

So when we call:

```java
eveningTea.getDescription();
eveningTea.getCost();
```

the final result includes all added layers.

## Why this is useful

Without Decorator, you may end up creating many rigid classes like:

- `GingerTea`
- `HoneyTea`
- `LemonTea`
- `GingerHoneyTea`
- `HoneyLemonTea`

That grows very quickly.

With Decorator:

- the base object stays small
- features are added dynamically
- combinations become flexible

## Why this example feels practical

People customize things every day:

- tea
- coffee
- sandwiches
- gift wrapping

The Decorator pattern fits naturally whenever something starts simple and gains optional layers.
