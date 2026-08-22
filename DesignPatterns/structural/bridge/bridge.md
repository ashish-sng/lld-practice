# Bridge Pattern: Incident Alerting System

Bridge is a **structural design pattern** used when we have **two dimensions that can vary independently**.

Instead of creating a separate subclass for every combination, we **separate the abstraction from its implementation** and connect them using **composition**.

In your example:

- one dimension is **type of alert**
- another dimension is **channel used to send the alert**

That is why Bridge fits very naturally here.

---

## What Problem Does Bridge Solve?

Suppose a company has different kinds of alerts:

- security alerts
- production alerts
- billing alerts

And these alerts can be sent through different channels:

- Slack
- PagerDuty
- Email

If we solve this only with inheritance, we may end up creating classes like:

- `SecuritySlackAlert`
- `SecurityPagerDutyAlert`
- `ProductionSlackAlert`
- `ProductionPagerDutyAlert`
- `BillingEmailAlert`

This becomes difficult to manage because the number of classes grows very fast.

If there are:

- 3 alert types
- 3 channels

then we may need 9 combinations.

If later one more alert type or one more channel is added, many more combinations appear.

This is called **class explosion**.

Bridge solves this by splitting the design into two separate hierarchies.

---

## Core Idea of Bridge

Bridge says:

- keep the **business abstraction** separate
- keep the **implementation details** separate
- connect them using a reference

In simple words:

- `Alert` decides **what kind of alert this is**
- `AlertChannel` decides **how the alert is delivered**

So instead of inheritance for every combination, we do runtime composition like this:

```java
Alert alert = new SecurityAlert(new PagerDutyAlertChannel());
```

This means:

- alert type = `SecurityAlert`
- delivery mechanism = `PagerDutyAlertChannel`

That single line represents the Bridge pattern very clearly.

---

## How It Is Structured in This Example

### 1. Implementation hierarchy

This side contains the delivery mechanism.

- `AlertChannel`
- `SlackAlertChannel`
- `PagerDutyAlertChannel`

`AlertChannel` is the interface that defines the common contract:

```java
void send(String alertType, String target, String message);
```

Each concrete channel provides its own sending behavior.

### 2. Abstraction hierarchy

This side contains the business meaning.

- `Alert`
- `SecurityAlert`

`Alert` is the abstract base class.

It stores a reference to `AlertChannel`:

```java
protected AlertChannel channel;
```

This reference is the actual **bridge** between the two hierarchies.

`SecurityAlert` defines alert-specific behavior and delegates delivery to the channel.

---

## Flow of Control

Consider this:

```java
Alert alert = new SecurityAlert(new PagerDutyAlertChannel());
alert.notify("identity-service", "Multiple failed admin login attempts detected");
```

Flow:

1. `PagerDutyAlertChannel` object is created
2. that object is passed into `SecurityAlert`
3. `SecurityAlert` passes it to the parent `Alert` constructor using `super(...)`
4. `Alert` stores it in the `channel` field
5. when `notify(...)` is called, `SecurityAlert` creates the business message
6. `SecurityAlert` delegates the actual sending work to `channel.send(...)`

So:

- `SecurityAlert` knows the business context
- `PagerDutyAlertChannel` knows the delivery mechanism

This separation is the essence of Bridge.

---

## Why We Need Bridge Here

We use Bridge here because:

- alert types may grow independently
- delivery channels may also grow independently
- both dimensions should not be tightly coupled

Benefits:

- avoids subclass explosion
- improves flexibility
- supports runtime composition
- makes code easier to extend
- keeps responsibilities separated

If tomorrow you add:

- `ProductionAlert`
- `EmailAlertChannel`

you do not need to modify existing classes heavily.

You just create the new class and compose it with existing ones.

---

## Why Composition Is Better Than Inheritance Here

Inheritance works well when there is only one dimension of variation.

But here we have two:

- alert category
- delivery platform

If both are modeled using inheritance together, the design becomes rigid.

Composition is better because we can plug one object into another at runtime.

Example:

```java
Alert alert1 = new SecurityAlert(new SlackAlertChannel());
Alert alert2 = new SecurityAlert(new PagerDutyAlertChannel());
```

Same alert type, different channel.

That flexibility is much harder and messier with pure inheritance.

---

## What Each Class Represents

### `AlertChannel`

- implementation interface
- defines how alerts are sent

### `SlackAlertChannel`

- concrete implementation
- knows how to send through Slack

### `PagerDutyAlertChannel`

- concrete implementation
- knows how to send through PagerDuty

### `Alert`

- abstraction
- holds a reference to `AlertChannel`

### `SecurityAlert`

- refined abstraction
- defines alert-specific business meaning

### `Main`

- client code
- decides which abstraction should work with which implementation

---

## Important Terms to Remember

- **Abstraction**: high-level business side
- **Refined Abstraction**: concrete version of abstraction
- **Implementor**: interface for implementation side
- **Concrete Implementor**: actual implementation class
- **Bridge**: the connection between abstraction and implementation using composition

In this example:

- Abstraction = `Alert`
- Refined Abstraction = `SecurityAlert`
- Implementor = `AlertChannel`
- Concrete Implementors = `SlackAlertChannel`, `PagerDutyAlertChannel`

---

## Interview Revision Notes

### One-line definition

Bridge decouples an abstraction from its implementation so that both can vary independently.

### When should you think of Bridge?

Use Bridge when:

- there are two independent dimensions of change
- inheritance is creating too many combinations
- you want runtime flexibility
- abstraction and implementation should evolve separately

### Recognizable signal

If you hear:

- “We have many types of X”
- “We also have many ways to perform/deliver/store/render X”

then Bridge is often a good candidate.

### Main benefit

It prevents subclass explosion by replacing combination-based inheritance with composition.

### Main drawback

- adds more classes
- can feel slightly more abstract initially
- may be unnecessary for very small problems

---

## Common Interview Questions

### 1. What is the Bridge pattern?

Bridge is a structural pattern that separates abstraction from implementation so both can change independently.

### 2. Why is it called Bridge?

Because the abstraction side holds a reference to the implementation side, forming a bridge between two separate hierarchies.

### 3. What problem does it solve?

It solves subclass explosion when two different dimensions vary independently.

### 4. What are the two hierarchies in this example?

- `Alert` hierarchy
- `AlertChannel` hierarchy

### 5. Where is the actual bridge in code?

Inside the abstraction:

```java
protected AlertChannel channel;
```

and the constructor:

```java
public Alert(AlertChannel channel) {
    this.channel = channel;
}
```

### 6. Why not just use inheritance?

Because inheritance would require a new subclass for every alert type and channel combination.

### 7. What is the biggest advantage of Bridge?

Independent extensibility of both dimensions.

### 8. Is Bridge decided at compile time or runtime?

Mostly at runtime, because the abstraction can be composed with different implementations dynamically.

---

## Bridge vs Similar Patterns

Bridge is often confused with Adapter, Strategy, and Decorator.

### Bridge vs Adapter

**Similarity**

- both use composition
- both connect one object with another

**Difference**

- Bridge is designed upfront to let two hierarchies vary independently
- Adapter is used later to make incompatible interfaces work together

Simple memory trick:

- **Bridge** = planned separation
- **Adapter** = compatibility fix

### Bridge vs Strategy

**Similarity**

- both use composition
- both allow behavior to be changed at runtime

**Difference**

- Strategy focuses on swapping an algorithm or behavior
- Bridge focuses on separating abstraction from implementation across two dimensions

Simple memory trick:

- **Strategy** = choose one behavior
- **Bridge** = separate two evolving hierarchies

### Bridge vs Decorator

**Similarity**

- both wrap another object
- both rely on composition

**Difference**

- Decorator adds responsibilities while keeping the same interface
- Bridge separates abstraction from implementation

Simple memory trick:

- **Decorator** = add features
- **Bridge** = split dimensions

### Bridge vs Facade

**Similarity**

- both are structural patterns
- both help organize complexity

**Difference**

- Facade simplifies usage of a subsystem
- Bridge separates two independent axes of variation

Simple memory trick:

- **Facade** = simpler front door
- **Bridge** = flexible connection

---

## Why Bridge Is Different

Bridge is different because it is not mainly about:

- simplifying an existing subsystem
- wrapping incompatible code
- adding extra behavior
- switching just one algorithm

It is specifically about **separating two dimensions that should evolve independently**.

That is the most important thing to remember.

---

## Real-Life Industry Examples

Bridge appears naturally in cases like:

- alerts + delivery channels
- notifications + transport providers
- documents + storage backends
- reports + export formats
- devices + remote controls
- UI components + rendering engines

Whenever there are two orthogonal axes of change, Bridge is a strong design option.

---

## Final Mental Model

Remember Bridge like this:

> One side says what the object means.  
> The other side says how it works underneath.

In your example:

- `SecurityAlert` says what kind of alert it is
- `PagerDutyAlertChannel` says how it gets sent

That is why this is a Bridge pattern.

---

## Quick Revision Summary

- Bridge is used for **two independent dimensions of change**
- it avoids **class explosion**
- it uses **composition instead of combination-heavy inheritance**
- abstraction holds a reference to implementation
- both hierarchies can evolve independently

In this example:

- abstraction side = `Alert`
- implementation side = `AlertChannel`
- bridge = `protected AlertChannel channel`

If you remember just this, you can explain Bridge clearly in most interviews.
