ISP (Interface Segregation Principle) is the 4th SOLID principle. It ensures that interfaces remain lean, focused, and role-specific.

Most candidates memorize:

> "Clients should not be forced to depend upon interfaces that they do not use."

But interviewers want to know **why** fat interfaces harm software architecture and how ISP interacts with LSP and SRP.

---

# Interface Segregation Principle (ISP)

### Definition

> No client should be forced to depend on methods it does not use.
> 
> Many client-specific interfaces are better than one general-purpose interface.

In simple terms: **Keep interfaces small, cohesive, and role-focused. Avoid "Fat Interfaces".**

---

## ❌ Without ISP

Imagine building a workplace task management system for human workers and AI/Robot workers.

### File: `Worker.java` (Fat Interface)

```java
public interface Worker {

    void work();

    void eat();

    void sleep();
}
```

---

### File: `HumanWorker.java`

```java
public class HumanWorker implements Worker {

    @Override
    public void work() {
        System.out.println("Human working");
    }

    @Override
    public void eat() {
        System.out.println("Human eating lunch");
    }

    @Override
    public void sleep() {
        System.out.println("Human taking a rest");
    }
}
```

---

### File: `RobotWorker.java`

```java
public class RobotWorker implements Worker {

    @Override
    public void work() {
        System.out.println("Robot working 24/7");
    }

    @Override
    public void eat() {
        // Robots don't eat! Forced dummy implementation or exception
        throw new UnsupportedOperationException("Robots don't eat");
    }

    @Override
    public void sleep() {
        // Robots don't sleep!
        throw new UnsupportedOperationException("Robots don't sleep");
    }
}
```

---

### File: `Main.java`

```java
public class Main {

    public static void main(String[] args) {
        Worker human = new HumanWorker();
        Worker robot = new RobotWorker();

        human.work();
        human.eat();

        robot.work();
        robot.eat(); // 💥 CRASHES at runtime with UnsupportedOperationException!
    }
}
```

---

# Why is this bad?

Look closely at `Worker`:

```java
public interface Worker
```

It is a **Fat Interface** (or "Polluted Interface"). It forces `RobotWorker` to implement methods like `eat()` and `sleep()` that make zero domain sense for a robot.

### Key Problems:

1. **Forced Dummy Implementations / Exceptions**:
   `RobotWorker` must either throw `UnsupportedOperationException` or provide empty `{ }` method bodies.

2. **Violation of Liskov Substitution Principle (LSP)**:
   Calling `worker.eat()` on a valid `Worker` instance (`RobotWorker`) crashes the application at runtime.

3. **Recompilation & Blast Radius**:
   If business logic adds `takeCoffeeBreak()` to `Worker`, every single class implementing `Worker` (even robots and automated scripts) is forced to change and recompile.

---

## Requirement Change

Business says:

> Add a `rechargeBattery()` step for electronic workers.

If you add `rechargeBattery()` directly to `Worker.java`:
- `HumanWorker` is now forced to implement `rechargeBattery()`!
- `HumanWorker` throws `UnsupportedOperationException("Humans don't recharge batteries")`.

This cascade of dummy implementations is the classic symptom of an ISP violation.

---

# ✅ Applying ISP

Split the fat interface into smaller, role-focused interfaces.

---

### File: `Workable.java`

```java
public interface Workable {

    void work();
}
```

---

### File: `Eatable.java`

```java
public interface Eatable {

    void eat();
}
```

---

### File: `Sleepable.java`

```java
public interface Sleepable {

    void sleep();
}
```

---

### File: `HumanWorker.java`

```java
// Humans work, eat, and sleep -> Implement all 3 role interfaces
public class HumanWorker implements Workable, Eatable, Sleepable {

    @Override
    public void work() {
        System.out.println("Human working");
    }

    @Override
    public void eat() {
        System.out.println("Human eating");
    }

    @Override
    public void sleep() {
        System.out.println("Human sleeping");
    }
}
```

---

### File: `RobotWorker.java`

```java
// Robots only work -> Implement only Workable!
public class RobotWorker implements Workable {

    @Override
    public void work() {
        System.out.println("Robot is working 24/7");
    }
}
```

---

### File: `Main.java`

```java
public class Main {

    public static void main(String[] args) {
        Workable human = new HumanWorker();
        Workable robot = new RobotWorker();

        human.work();
        robot.work(); // Clean, safe, zero runtime exceptions!

        Eatable eatingHuman = new HumanWorker();
        eatingHuman.eat();
    }
}
```

---

# What Changed?

Before (Fat Interface):

```text
       Worker (work, eat, sleep)
        ▲                      ▲
        │                      │
   HumanWorker            RobotWorker
 (implements all)       (throws exceptions for eat/sleep)
```

---

After (Role-Segregated Interfaces):

```text
    Workable           Eatable           Sleepable
     ▲     ▲              ▲                  ▲
     │     │              │                  │
     │   HumanWorker ─────┼──────────────────┘
     │   (implements Workable, Eatable, Sleepable)
     │
  RobotWorker
  (implements Workable only)
```

Now each client depends **only** on the contract methods it actually requires!

---

# Why Is ISP Important?

---

## 1. Zero Dummy / Throwing Methods

`UnsupportedOperationException` and empty `{ }` methods vanish completely. Every implemented method performs real, meaningful work.

---

## 2. Reduced Blast Radius & Recompilation

Adding new methods to `Eatable` (e.g. `drinkWater()`) will **only** affect `HumanWorker`. `RobotWorker` remains completely untouched and does not need recompilation.

---

## 3. High Cohesion & Flexibility

Classes can combine multiple fine-grained interfaces as needed. For instance, a `SuperRobot` could implement `Workable` and `Rechargeable` without touching `Eatable`.

---

# Real-World & Java Standard Library Examples

### 1. Java Standard Library Interfaces (`java.util`)
Java separates collections into fine-grained interfaces rather than one monolithic collection contract:
- `Iterable` (for objects that can be iterated in `for-each` loops)
- `Collection` (for element grouping)
- `List` (for ordered sequence access)
- `RandomAccess` (marker interface indicating $O(1)$ index lookup)

If Java combined all of these into a single fat interface, simple arrays or read-only iterators would be forced to implement `add()`, `remove()`, and `sort()`.

### 2. Multi-Function Printer (MFP) Hardware Drivers
Instead of a single `PrinterDevice` interface containing `print()`, `scan()`, `fax()`, `staple()`:
- `Printer` (`print()`)
- `Scanner` (`scan()`)
- `FaxMachine` (`fax()`)

A basic black-and-white desk printer implements `Printer`. An enterprise office scanner/copier implements `Printer, Scanner, FaxMachine`.

---

# Interview Questions

---

## Q1: What is the difference between SRP and ISP?

- **SRP (Single Responsibility Principle)** is focused on **Classes and Modules**: A class should have only one reason to change.
- **ISP (Interface Segregation Principle)** is focused on **Interfaces and Contracts**: An interface should be role-specific so clients aren't forced to depend on unused methods.

---

## Q2: Can ISP lead to "Interface Explosion" (too many tiny interfaces)?

Yes, over-applying ISP can lead to thousands of single-method interfaces (e.g. `Doable`, `Runable`, `Flyable`, `Printable`). 

**Interview Best Practice**: Group methods that naturally belong together in a single domain role. Segregate interfaces based on **client roles**, not just blindly creating 1-method interfaces for every single operation.

---

## Q3: How does violating ISP lead to violating LSP?

When an interface is too broad (Fat Interface), implementing classes are forced to override methods they don't support by throwing `UnsupportedOperationException`.

When a client expects the interface contract to work, passing that subclass breaks the application at runtime—violating **Liskov Substitution Principle (LSP)**!

---

## Q4: How does ISP relate to DIP?

DIP says *"Depend on abstractions, not concrete classes"*.
ISP says *"Ensure those abstractions are lean and client-focused"*.

If you apply DIP by depending on an interface, but that interface is a 50-method Fat Interface, you still have tight coupling! ISP cleans up the abstractions that DIP depends on.

---

# Common Interview Smells (ISP Violations)

Whenever you see:

1. Methods throwing `UnsupportedOperationException` or `NotImplementedException`:
   ```java
   @Override
   public void scan() {
       throw new UnsupportedOperationException();
   }
   ```

2. Empty method implementations:
   ```java
   @Override
   public void onPaymentFailed() {
       // Do nothing - not needed for cash payments
   }
   ```

3. Fat Interfaces with 15+ unrelated methods ("God Interfaces").

Ask yourself:

> *"Is this client being forced to implement methods it does not use?"*

If yes, ISP is being violated!

---

# One-Line Memory Trick

For all SOLID principles:

```text
SRP -> One reason to change

OCP -> Extend, don't modify

LSP -> Child must behave like parent

ISP -> Don't force unused methods

DIP -> Depend on interfaces, not implementations
```
