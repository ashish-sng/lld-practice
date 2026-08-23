# Design Patterns Revision Notes

This file explains common terms used in design patterns in very simple language.

Use this like a quick revision sheet.

---

## 1. Class

A **class** is a blueprint.

It tells us:

- what data an object will have
- what actions an object can do

Example:

```java
class Car {
    String brand;

    void start() {
        System.out.println("Car started");
    }
}
```

Here, `Car` is a class.

---

## 2. Object

An **object** is a real instance created from a class.

Example:

```java
Car myCar = new Car();
```

Here, `myCar` is an object.

Simple meaning:

- class = blueprint
- object = real thing created from blueprint

---

## 3. Interface

An **interface** is a contract.

It says:

- “any class implementing me must provide these methods”

It usually tells **what should be done**, not **how it is done**.

Example:

```java
interface PaymentGateway {
    void pay(int amount);
}
```

Simple meaning:

- interface = promise/contract

---

## 4. Implementation

An **implementation** is the actual code that fulfills an interface or abstract method.

Example:

```java
class RazorpayGateway implements PaymentGateway {
    public void pay(int amount) {
        System.out.println("Paid using Razorpay");
    }
}
```

Here:

- `PaymentGateway` says what must exist
- `RazorpayGateway` gives the real implementation

Simple meaning:

- interface = what
- implementation = how

---

## 5. Abstraction

**Abstraction** means showing only the important idea and hiding unnecessary details.

We focus on:

- what something does

instead of:

- how everything works internally

Example:

When you drive a car, you use:

- steering
- brake
- accelerator

You do not need to know all engine details.

That is abstraction.

In code:

- interface and abstract class often help create abstraction

Simple meaning:

- abstraction = focus on essential behavior, hide inner complexity

---

## 6. Abstract Class

An **abstract class** is a partial blueprint.

It is used when:

- some behavior is common
- some behavior should be completed by child classes

Example:

```java
abstract class Alert {
    abstract void notifyUser();
}
```

You usually cannot create an object directly from an abstract class.

Simple meaning:

- abstract class = incomplete base class

---

## 7. Concrete Class

A **concrete class** is a normal, complete class.

You can create objects from it directly.

Example:

```java
class SecurityAlert extends Alert {
    void notifyUser() {
        System.out.println("Security alert sent");
    }
}
```

Simple meaning:

- abstract class = incomplete
- concrete class = complete

---

## 8. Inheritance

**Inheritance** means one class takes properties and behavior from another class.

Example:

```java
class Animal {
    void eat() {}
}

class Dog extends Animal {
    void bark() {}
}
```

Here:

- `Dog` inherits from `Animal`

Simple meaning:

- inheritance = “is-a” relationship
- `Dog` is an `Animal`

---

## 9. Composition

**Composition** means one class contains another class as a field and uses it.

Example:

```java
class Engine {
    void start() {}
}

class Car {
    private Engine engine = new Engine();
}
```

Here:

- `Car` has an `Engine`

This is composition.

Simple meaning:

- composition = “has-a” relationship
- `Car` has an `Engine`

Very important:

- inheritance = is-a
- composition = has-a

Design patterns use composition a lot because it gives more flexibility.

---

## 10. Association

**Association** means two classes are connected in some way.

Example:

- `Teacher` and `Student`
- `Customer` and `Order`

They know about each other or interact.

Simple meaning:

- association = general relationship between two classes

---

## 11. Aggregation

**Aggregation** is a weaker form of composition.

It means one object uses another, but the other object can still exist separately.

Example:

- `Department` has `Professor`
- a professor can still exist even if department changes

Simple meaning:

- aggregation = has-a relationship, but loosely connected

---

## 12. Encapsulation

**Encapsulation** means keeping data and methods together in one class and controlling access to internal data.

Example:

```java
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }
}
```

Here:

- `balance` is hidden from direct outside access

Simple meaning:

- encapsulation = protect internal data and expose only safe operations

---

## 13. Polymorphism

**Polymorphism** means the same method call can behave differently depending on the object.

Example:

```java
PaymentGateway gateway = new RazorpayGateway();
gateway.pay(100);
```

and later:

```java
PaymentGateway gateway = new StripeGateway();
gateway.pay(100);
```

Same method call:

```java
gateway.pay(100);
```

Different behavior based on actual object.

Simple meaning:

- one interface, many forms

---

## 14. Coupling

**Coupling** means how strongly two classes depend on each other.

If one class knows too much about another class, coupling is high.

High coupling is usually bad because:

- change in one class breaks another
- code becomes harder to maintain

Simple meaning:

- coupling = dependency strength between classes

Goal:

- low coupling is preferred

---

## 15. Cohesion

**Cohesion** means how focused a class is on one job.

If a class does one clear responsibility well, cohesion is high.

If a class does many unrelated things, cohesion is low.

Simple meaning:

- cohesion = how well a class sticks to one purpose

Goal:

- high cohesion is preferred

---

## 16. Dependency

A **dependency** means one class needs another class to do its work.

Example:

```java
class CheckoutService {
    private PaymentGateway paymentGateway;
}
```

`CheckoutService` depends on `PaymentGateway`.

Simple meaning:

- dependency = one class relies on another

---

## 17. Dependency Injection

**Dependency Injection** means giving a class the objects it needs from outside, instead of creating them inside.

Example:

```java
class CheckoutService {
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```

Simple meaning:

- dependency injection = supply dependency from outside

Why useful:

- easier testing
- less coupling
- more flexibility

---

## 18. Delegation

**Delegation** means one object forwards work to another object.

Example:

```java
channel.send("Security", target, message);
```

Here `SecurityAlert` does not send the alert itself.

It delegates that work to `channel`.

Simple meaning:

- delegation = asking another object to do the work

---

## 19. Client

The **client** is the code that uses other classes.

Example:

```java
public class Main {
    public static void main(String[] args) {
        Alert alert = new SecurityAlert(new SlackAlertChannel());
        alert.notify("auth-service", "Login failures");
    }
}
```

Here `Main` is the client.

Simple meaning:

- client = code that uses the design

---

## 20. Abstraction vs Implementation

This is a very common design-pattern phrase.

### Abstraction

Focuses on the high-level concept.

Example:

- `Alert`

### Implementation

Focuses on low-level execution details.

Example:

- `SlackAlertChannel`
- `PagerDutyAlertChannel`

Simple meaning:

- abstraction = business idea
- implementation = technical execution

---

## 21. Hierarchy

A **hierarchy** means a family of related classes.

Example:

- `Alert`
- `SecurityAlert`
- `ProductionAlert`

This is one hierarchy.

Another:

- `AlertChannel`
- `SlackAlertChannel`
- `PagerDutyAlertChannel`

Simple meaning:

- hierarchy = related classes grouped by inheritance or contract

---

## 22. Subclass

A **subclass** is a child class that extends a parent class.

Example:

```java
class SecurityAlert extends Alert
```

Here:

- `SecurityAlert` is subclass
- `Alert` is parent class

Simple meaning:

- subclass = child class

---

## 23. Superclass

A **superclass** is the parent/base class.

Example:

```java
class SecurityAlert extends Alert
```

Here:

- `Alert` is superclass

Simple meaning:

- superclass = parent class

---

## 24. Runtime Composition

This means combining objects while the program runs.

Example:

```java
Alert alert = new SecurityAlert(new PagerDutyAlertChannel());
```

Here the alert and channel are combined at runtime.

Simple meaning:

- runtime composition = choose and connect objects while program is running

---

## 25. Class Explosion

**Class explosion** happens when too many classes are created because of combinations.

Example:

- `SecuritySlackAlert`
- `SecurityPagerDutyAlert`
- `ProductionSlackAlert`
- `ProductionPagerDutyAlert`

This grows fast and becomes messy.

Simple meaning:

- class explosion = too many classes because of many combinations

---

## 26. Loose Coupling

**Loose coupling** means classes depend less on concrete details.

Example:

```java
private AlertChannel channel;
```

This is better than:

```java
private SlackAlertChannel channel;
```

because now the code can work with any channel implementation.

Simple meaning:

- loose coupling = flexible dependency

---

## 27. Tight Coupling

**Tight coupling** means code depends heavily on one specific class or detail.

Example:

```java
private SlackAlertChannel channel;
```

Now the code is stuck with Slack.

Simple meaning:

- tight coupling = rigid dependency

---

## 28. Reusability

**Reusability** means code can be used again in other places without rewriting.

Example:

- `SlackAlertChannel` can be reused by many alert types

Simple meaning:

- reusability = write once, use many times

---

## 29. Extensibility

**Extensibility** means code can be extended easily when new requirements come.

Example:

- adding `EmailAlertChannel`
- adding `ProductionAlert`

without rewriting everything

Simple meaning:

- extensibility = easy to grow

---

## 30. Responsibility

A **responsibility** is the job of a class.

Example:

- `SecurityAlert` creates security-specific message
- `PagerDutyAlertChannel` sends through PagerDuty

Simple meaning:

- responsibility = what this class is supposed to handle

---

## 31. Separation of Concerns

**Separation of concerns** means different classes should handle different jobs.

Example:

- alert meaning should be separate
- sending mechanism should be separate

This makes code cleaner.

Simple meaning:

- separate different problems into different classes

---

## 32. Design Pattern

A **design pattern** is a common reusable solution to a common software design problem.

It is not exact code.

It is a general approach or template.

Example:

- Adapter
- Bridge
- Decorator
- Factory

Simple meaning:

- design pattern = tried and trusted design idea

---

## 33. Structural Design Pattern

A **structural pattern** focuses on how classes and objects are organized and connected.

Examples:

- Adapter
- Bridge
- Decorator
- Facade
- Composite

Simple meaning:

- structural pattern = how pieces are connected

---

## 34. Behavioral Design Pattern

A **behavioral pattern** focuses on communication and responsibility between objects.

Examples:

- Strategy
- Observer
- Command

Simple meaning:

- behavioral pattern = how objects behave and interact

---

## 35. Creational Design Pattern

A **creational pattern** focuses on object creation.

Examples:

- Factory
- Singleton
- Builder

Simple meaning:

- creational pattern = how objects are created

---

## Quick Memory Tricks

- **Inheritance** = is-a
- **Composition** = has-a
- **Interface** = contract
- **Implementation** = real code
- **Abstraction** = important idea, hidden details
- **Delegation** = pass work to another object
- **Coupling** = dependency strength
- **Cohesion** = focus of a class
- **Extensibility** = easy to grow
- **Reusability** = use again

---

## Most Important Concepts for Design Patterns

If you revise only a few things first, revise these:

1. interface
2. abstraction
3. implementation
4. inheritance
5. composition
6. delegation
7. coupling
8. cohesion
9. dependency injection
10. separation of concerns

These terms appear again and again in almost every design pattern.
