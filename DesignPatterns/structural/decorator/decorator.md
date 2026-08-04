# Decorator Pattern

Decorator is a structural design pattern used to add behavior to an object dynamically without changing its class.

The biggest idea is:

- keep the same interface
- wrap the object
- add extra behavior layer by layer

It is preferred when we want flexible combinations of features without creating too many subclasses.

## Standard Industry Example

A very common real-world example is a notification system.

Suppose we have a base notifier:

- `EmailNotifier`

Now based on business need, we may want to add:

- Slack notifications
- SMS notifications
- WhatsApp notifications

For example:

- normal event: send only email
- important event: send email + Slack
- critical alert: send email + Slack + SMS + WhatsApp

If we try to model this only with inheritance, we may end up with too many classes like:

- `EmailNotifier`
- `EmailSlackNotifier`
- `EmailSlackSmsNotifier`
- `EmailSmsWhatsappNotifier`

That becomes hard to maintain.

Decorator solves this by wrapping one notifier inside another.

## Core Structure

- `NotificationService`
  - component interface
  - common contract for all objects

- `EmailNotifier`
  - concrete component
  - base implementation

- `NotificationDecorator`
  - base decorator
  - stores a reference to another `NotificationService`

- `SlackNotifierDecorator`
- `SmsNotifierDecorator`
- `WhatsappNotifierDecorator`
  - concrete decorators
  - add extra behavior while keeping the same interface

## Flow

We may start with:

```java
NotificationService notifier = new EmailNotifier();
```

Then add layers:

```java
notifier = new SlackNotifierDecorator(notifier);
notifier = new SmsNotifierDecorator(notifier);
```

Now one call:

```java
notifier.send("Payment failed for order #123");
```

will trigger:

- email
- Slack
- SMS

Each decorator first delegates to the wrapped object, then adds its own behavior.

That means behavior is built step by step through composition.

## Why This Is Decorator

Decorator works because:

- all layers implement the same interface
- each decorator wraps another object of the same interface type
- client code does not need to care how many layers are present

So the object becomes more capable without changing the original class.

## Key Benefits

- avoids subclass explosion
- adds behavior at runtime
- follows composition over inheritance
- keeps base classes simple
- allows flexible combinations of features

## Interview Definition

Decorator adds responsibilities to an object dynamically by wrapping it, while keeping the same interface.

## Interview Mental Model

Think of Decorator as:

- "same object from outside"
- "enhanced behavior inside"

The client still talks to the same interface, but internally extra layers are attached.

## Decorator vs Adapter

- Decorator keeps the same interface and adds behavior.
- Adapter changes one interface into another.

Shortcut:

- Adapter = translator
- Decorator = enhancer

## Decorator vs Facade

- Decorator adds features to one object.
- Facade simplifies access to a group of objects.

Shortcut:

- Facade hides complexity
- Decorator adds capability

## Decorator vs Builder

- Decorator is used to add behavior to an existing object dynamically.
- Builder is used to create a complex object step by step.

Shortcut:

- Builder = object creation
- Decorator = object enhancement

In simple words:

- Builder answers:
  - "How do I construct this object cleanly?"
- Decorator answers:
  - "How do I add more features to this object without changing its base class?"

## When To Use

Use Decorator when:

- you want optional features that can be combined
- you want to avoid many subclasses for every combination
- you want to add behavior without modifying existing classes

Very common use cases:

- notifications
- logging
- caching
- retry handling
- authentication layers
- compression/encryption streams
- middleware pipelines

## Interview Notes

- Pattern type:
  - structural

- Main problem it solves:
  - too many subclasses for feature combinations

- Main design principle:
  - composition over inheritance

- Key sign that Decorator fits:
  - "I want to add optional features around an object, and features can be stacked."

- Watch for this question in interviews:
  - "How is Decorator different from inheritance?"
  - Good answer:
    - inheritance adds behavior statically at class level
    - decorator adds behavior dynamically at object level

- Another strong interview line:
  - "Decorator is useful when behavior needs to be layered without changing the client contract."

## Quick Revision Summary

- same interface
- wrapper object
- adds behavior dynamically
- avoids subclass explosion
- best understood as stacked feature layers
