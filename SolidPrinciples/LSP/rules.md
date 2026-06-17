These are the **formal LSP rules** that many interviewers ask after the basic examples.

LSP isn't just "child should behave like parent." There are specific rules around:

1. Return Types
2. Method Arguments (Parameters)
3. Exceptions

---

# 1. Return Type Rule

### Rule

A subclass can return:

* The same type ✅
* A more specific type (covariant return type) ✅

But not a less specific type ❌

---

## Example

### Parent

```java
class Animal {
}
```

```java
class Dog extends Animal {
}
```

---

### Valid

```java
class AnimalFactory {

    public Animal getAnimal() {
        return new Animal();
    }
}
```

```java
class DogFactory extends AnimalFactory {

    @Override
    public Dog getAnimal() {
        return new Dog();
    }
}
```

Why?

Because every `Dog` is an `Animal`.

The caller expects:

```java
Animal animal = factory.getAnimal();
```

A `Dog` satisfies that expectation.

---

### Invalid

Suppose:

```java
class Vehicle {
}
```

```java
class Car extends Vehicle {
}
```

Parent:

```java
class Factory {

    public Animal create() {
        return new Animal();
    }
}
```

Child:

```java
class VehicleFactory extends Factory {

    @Override
    public Vehicle create() {
        return new Vehicle();
    }
}
```

Compiler error.

Because callers expect:

```java
Animal animal = factory.create();
```

But they might receive a `Vehicle`.

Contract broken.

---

# 2. Method Argument Rule

### Rule

A child class must not require stricter inputs than the parent.

Think:

> If parent accepts X, child must accept at least X.

---

## LSP Violation

### Parent

```java
class Bird {

    public void eat(Food food) {
        System.out.println("Eating food");
    }
}
```

---

### Child

```java
class Sparrow extends Bird {

    @Override
    public void eat(Food food) {

        if (!(food instanceof Seeds)) {
            throw new IllegalArgumentException(
                "Only seeds allowed");
        }

        System.out.println("Eating seeds");
    }
}
```

---

### Client

```java
Bird bird = new Sparrow();

bird.eat(new Worm());
```

Parent contract:

```java
eat(Food)
```

accepts all food.

Child secretly narrows that to:

```java
eat(Seeds)
```

That's an LSP violation.

---

## Correct Design

Instead of inheriting:

```java
Bird
```

create separate abstractions:

```java
SeedEatingBird
```

```java
CarnivorousBird
```

The child should not tighten the accepted inputs.

---

# 3. Exception Rule

### Rule

A subclass should not throw broader or new checked exceptions than the parent.

Why?

Because callers rely on the parent's exception contract.

---

## LSP Violation

### Parent

```java
class PaymentService {

    public void pay() {
        System.out.println("Payment successful");
    }
}
```

---

### Child

```java
class BankPaymentService extends PaymentService {

    @Override
    public void pay() throws Exception {

        throw new Exception("Bank error");
    }
}
```

Compiler error.

Java prevents this.

---

Because:

Client code:

```java
PaymentService service =
        new BankPaymentService();

service.pay();
```

expects:

```java
pay()
```

to throw no checked exceptions.

The child changed the contract.

---

## Valid Example

Parent:

```java
class PaymentService {

    public void pay()
            throws IOException {

    }
}
```

Child:

```java
class BankPaymentService
        extends PaymentService {

    @Override
    public void pay()
            throws FileNotFoundException {

    }
}
```

Valid.

Because:

```java
FileNotFoundException
```

is more specific than:

```java
IOException
```

The child is not expanding the exception contract.

---

# Easy Interview Summary

## Return Type Rule

Child may return:

```java
ParentType -> ChildType
```

✅ Allowed

```java
Animal -> Dog
```

❌ Not allowed

```java
Dog -> Animal
```

when overriding.

Reason:
The caller expects at least the parent's return type.

---

## Argument Rule

Child must not require stricter inputs.

Parent:

```java
eat(Food)
```

Child:

```java
eat(SeedsOnly)
```

❌ LSP Violation

Reason:
Code written for the parent may fail for the child.

---

## Exception Rule

Child must not throw broader checked exceptions.

Parent:

```java
pay() throws IOException
```

Child:

```java
pay() throws Exception
```

❌ LSP Violation

Reason:
The caller wasn't prepared to handle the broader exception.

---

A concise way to remember LSP's formal rules is:

> **Children should accept at least what the parent accepts, return at least what the parent promises, and throw no more than the parent declares.**

That's the essence of the parameter rule, return type rule, and exception rule.
