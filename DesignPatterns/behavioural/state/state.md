# State Pattern in This Example

This example uses the State pattern for a very human situation:

- how a person’s study behavior changes based on their current mental state

A student may begin fresh, then become distracted, then feel exhausted, and after a break become fresh again. The same person is still studying the same topic, but the behavior changes depending on the current state.

That changing internal condition is what the State pattern models.

## Classes and their roles

- `FocusState`
  - This is the state interface.
  - It defines:
    - `study(FocusSession session)`
    - `getName()`

- `FreshState`
  - Represents a focused and energetic mind.
  - The student can do deep work here.

- `DistractedState`
  - Represents a loss of concentration.
  - The student shifts to lighter work.

- `ExhaustedState`
  - Represents mental fatigue.
  - The student needs a break before returning to effective study.

- `FocusSession`
  - This is the context class.
  - It stores the current state and the topic being studied.
  - It delegates behavior to the current state object.

## How it works step by step

In `Main`, we create:

```java
FocusSession focusSession = new FocusSession("System Design");
```

Inside the constructor, the session starts with:

```java
this.currentState = new FreshState();
```

So the first behavior comes from `FreshState`.

When this runs:

```java
focusSession.study();
```

the context does not directly decide what to do.
It forwards the action to the current state:

```java
currentState.study(this);
```

## What each state is doing

### `FreshState`

```java
System.out.println("Mind is fresh. Deep work starts on " + session.getTopic());
session.setState(new DistractedState());
```

This means:

- the session behaves like a focused student
- after that, the internal state changes to `DistractedState`

### `DistractedState`

```java
System.out.println("Attention is drifting. Switching to short tasks for " + session.getTopic());
session.setState(new ExhaustedState());
```

This means:

- behavior changes because concentration dropped
- the next state becomes `ExhaustedState`

### `ExhaustedState`

```java
System.out.println("Energy is low. Taking a break before continuing " + session.getTopic());
session.setState(new FreshState());
```

This means:

- the student is too tired for quality work
- after rest, the session returns to `FreshState`

## What makes this State pattern

The key idea is:

- behavior changes because the object’s internal state changes

The `FocusSession` object remains the same object throughout.
But when its internal state changes, calling `study()` produces different behavior.

So this is not just choosing one behavior from outside.
The object is moving through states on its own.

## How this is different from Strategy

Strategy is usually:

- "choose the best approach"

State is usually:

- "behavior changes because the object is now in a different condition"

In the Strategy example, we manually changed how to study.

In this State example, the session itself moves from:

- fresh
- distracted
- exhausted
- fresh again

That transition is part of the behavior.

## Why this is useful

Without State, `FocusSession` might contain many condition checks like:

- if fresh, do deep work
- if distracted, do smaller tasks
- if exhausted, take a break

As more mental states are added, that logic becomes messy.

With State:

- each state keeps its own behavior
- each state can decide the next state
- the context stays simpler

## Why this example feels practical

This example is relatable because people rarely perform the same way all day.

A person studying may naturally move through:

- high focus
- fading attention
- low energy
- recovery

That is exactly the kind of changing internal condition the State pattern is designed for.
