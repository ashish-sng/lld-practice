
---

# Liskov Substitution Principle (LSP)

**Definition:**

> Objects of a subclass should be replaceable with objects of the parent class without breaking the correctness of the program.

In simple terms:

> If `Dog` is an `Animal`, then anywhere I use an `Animal`, I should be able to use a `Dog` without unexpected behavior.

---

# ❌ Violating LSP

The classic example is Rectangle and Square.

### File: `Rectangle.java`

```java
public class Rectangle {

    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
```

---

### File: `Square.java`

```java
public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }
}
```

---

### File: `Main.java`

```java
public class Main {

    public static void main(String[] args) {

        Rectangle rectangle = new Square();

        rectangle.setWidth(5);
        rectangle.setHeight(10);

        System.out.println(rectangle.getArea());
    }
}
```

What do we expect?

```text
5 * 10 = 50
```

What do we get?

```text
100
```

Because:

```java
rectangle.setWidth(5);
```

makes

```java
width = 5
height = 5
```

and

```java
rectangle.setHeight(10);
```

makes

```java
width = 10
height = 10
```

---

## Why is this an LSP violation?

The code expects a `Rectangle`.

But when we substitute a `Square`, behavior changes unexpectedly.

The subclass broke the contract of the parent class.

This violates:

> A subclass should be usable anywhere its parent is expected.

---

# Why is LSP Important?

Imagine a team writes:

```java
public int calculateArea(Rectangle rectangle) {
    rectangle.setWidth(5);
    rectangle.setHeight(10);

    return rectangle.getArea();
}
```

They test it with:

```java
new Rectangle()
```

Everything works.

Months later somebody passes:

```java
new Square()
```

Suddenly:

```text
Expected = 50
Actual = 100
```

The caller did nothing wrong.

The subclass broke the assumptions.

This is exactly what LSP protects against.

---

# Another Real-World Example

### ❌ Bad Design

```java
class Bird {

    public void fly() {
        System.out.println("Flying");
    }
}
```

```java
class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException(
            "Penguins can't fly"
        );
    }
}
```

Usage:

```java
Bird bird = new Penguin();
bird.fly();
```

Runtime:

```text
Exception!
```

---

This violates LSP because:

The parent promises:

```java
fly()
```

works.

The child says:

```java
Nope, it throws an exception.
```

A `Penguin` cannot safely replace a `Bird`.

---

# ✅ Following LSP

Instead of forcing every bird to fly:

### File: `Bird.java`

```java
public abstract class Bird {

    public void eat() {
        System.out.println("Eating");
    }
}
```

---

### File: `FlyingBird.java`

```java
public abstract class FlyingBird extends Bird {

    public abstract void fly();
}
```

---

### File: `Sparrow.java`

```java
public class Sparrow extends FlyingBird {

    @Override
    public void fly() {
        System.out.println("Flying");
    }
}
```

---

### File: `Penguin.java`

```java
public class Penguin extends Bird {

}
```

Now:

```java
FlyingBird bird = new Sparrow();
bird.fly();
```

works.

And:

```java
Bird bird = new Penguin();
```

also works.

No broken contracts.

---

# The Core Idea

Whenever a subclass has to do one of these:

```java
throw new UnsupportedOperationException();
```

or

```java
if (...)
    // special handling because child behaves differently
```

or

```java
return null;
```

because it cannot fulfill the parent's contract,

that's often a sign of an LSP violation.

---

# Interview Answer

If asked:

### "Why is LSP important?"

Say:

> LSP ensures that subclasses can replace their parent classes without changing the expected behavior of the program. It prevents inheritance hierarchies where child classes violate the contracts established by their parents, reducing bugs and making polymorphism reliable.

### One-line summary

* **SRP** → One reason to change.
* **OCP** → Add features without modifying existing code.
* **LSP** → A child class must behave like a valid substitute for its parent.
