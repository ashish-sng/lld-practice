# Facade Pattern in This Example

This example uses the Facade pattern for a very normal daily-life situation:

- getting ready for office in the morning

A real morning routine may involve many small steps:

- turning off the alarm
- making coffee
- starting the shower
- packing the bag

If the client code had to call every object directly every time, it would become repetitive and noisy. The Facade pattern gives one simple entry point for a bigger process.

## Classes and their roles

- `Alarm`
  - Handles turning off the alarm.

- `CoffeeMachine`
  - Handles brewing coffee.

- `Shower`
  - Handles starting the shower.

- `Bag`
  - Handles packing work essentials.

- `MorningRoutineFacade`
  - This is the facade.
  - It hides the small internal steps and exposes one simple method:
    - `getReadyForOffice()`

## How it works

In `Main`, the client only does this:

```java
MorningRoutineFacade morningRoutineFacade = new MorningRoutineFacade();
morningRoutineFacade.getReadyForOffice();
```

Inside `getReadyForOffice()`, the facade coordinates all the subsystem objects:

```java
alarm.turnOff();
coffeeMachine.brewCoffee();
shower.start();
bag.packEssentials();
```

So the client does not need to know the full sequence.

## Why this is useful

The main benefit is simplicity.

The client sees:

- one object
- one high-level method

instead of managing several small objects and remembering the correct order.

## Why this example feels practical

People do this kind of grouping all the time.
We think in terms of:

- "get ready for office"
- "prepare for a trip"
- "start movie night"

not in terms of every tiny technical step.

That is exactly what the Facade pattern helps represent.
