## Open-Closed Principle (OCP)

**Definition:**

> Software entities (classes, modules, functions) should be **open for extension** but **closed for modification**.

In simple terms:

* You should be able to add new behavior.
* You should not need to modify existing, working code.

---

# ❌ Violating OCP

Suppose we have a payment system.

```java
class PaymentProcessor {

    public void processPayment(String paymentType) {

        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Processing Credit Card Payment");
        }
        else if (paymentType.equals("PAYPAL")) {
            System.out.println("Processing PayPal Payment");
        }
    }
}
```

Usage:

```java
PaymentProcessor processor = new PaymentProcessor();
processor.processPayment("CREDIT_CARD");
```

---

## What's wrong?

Today we support:

* Credit Card
* PayPal

Tomorrow business says:

> Add UPI payment.

Now we modify existing code:

```java
class PaymentProcessor {

    public void processPayment(String paymentType) {

        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Processing Credit Card Payment");
        }
        else if (paymentType.equals("PAYPAL")) {
            System.out.println("Processing PayPal Payment");
        }
        else if (paymentType.equals("UPI")) {
            System.out.println("Processing UPI Payment");
        }
    }
}
```

---

## Why is this dangerous?

Imagine the original code was:

```java
if (paymentType.equals("CREDIT_CARD"))
```

While adding UPI, a developer accidentally writes:

```java
if (paymentType.equals("CREDITCARD"))
```

Notice the missing underscore.

Now Credit Card payments stop working.

### Requirement

Add UPI.

### Result

Credit Card payments broke.

This is exactly the problem OCP tries to solve.

---

# Real-World Consequence

Suppose this code is running in production.

Before modification:

```java
Credit Card ✅
PayPal ✅
```

After adding UPI:

```java
Credit Card ❌
PayPal ✅
UPI ✅
```

The business asked for:

> "Add a new feature."

But we accidentally broke an old feature.

This happens because we modified tested, stable code.

---

# ✅ Applying OCP

Create an abstraction.

```java
interface PaymentMethod {
    void processPayment();
}
```

---

## Credit Card

```java
class CreditCardPayment implements PaymentMethod {

    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card Payment");
    }
}
```

---

## PayPal

```java
class PayPalPayment implements PaymentMethod {

    @Override
    public void processPayment() {
        System.out.println("Processing PayPal Payment");
    }
}
```

---

## Payment Processor

```java
class PaymentProcessor {

    public void processPayment(PaymentMethod paymentMethod) {
        paymentMethod.processPayment();
    }
}
```

Usage:

```java
PaymentProcessor processor = new PaymentProcessor();

processor.processPayment(
    new CreditCardPayment()
);
```

---

# New Requirement: Add UPI

Create a new class.

```java
class UpiPayment implements PaymentMethod {

    @Override
    public void processPayment() {
        System.out.println("Processing UPI Payment");
    }
}
```

Usage:

```java
processor.processPayment(
    new UpiPayment()
);
```

---

## What changed?

Did we touch:

```java
PaymentProcessor
```

❌ No

Did we touch:

```java
CreditCardPayment
```

❌ No

Did we touch:

```java
PayPalPayment
```

❌ No

We simply **extended** the system by adding a new class.

That's OCP.

---

# Why OCP is Important

## 1. Reduces Risk of Breaking Existing Code

Without OCP:

```java
PaymentProcessor
```

changes every time a new payment method is added.

Every modification risks introducing bugs.

With OCP:

```java
CreditCardPayment
PayPalPayment
UpiPayment
```

are isolated.

Adding one doesn't affect the others.

---

## 2. Stable Code Stays Stable

Think of production code like a building foundation.

You don't want to keep digging up the foundation every time you add a new room.

OCP says:

> Leave the foundation alone. Build extensions.

---

## 3. Easier Testing

Without OCP:

Every new payment method requires retesting the entire `PaymentProcessor`.

With OCP:

Only test:

```java
UpiPayment
```

The rest is already proven.

---

## 4. Better Scalability

Imagine after a year:

```text
Credit Card
PayPal
UPI
Net Banking
Apple Pay
Google Pay
Crypto
```

Without OCP:

```java
if (...)
else if (...)
else if (...)
else if (...)
else if (...)
else if (...)
```

A giant mess.

With OCP:

```java
class ApplePayPayment implements PaymentMethod
class GooglePayPayment implements PaymentMethod
class CryptoPayment implements PaymentMethod
```

Clean and scalable.

---

# React Example (Very Common)

### ❌ OCP Violation

```jsx
function Button({ type }) {

  if (type === "primary") {
    return <button>Primary</button>;
  }

  if (type === "secondary") {
    return <button>Secondary</button>;
  }

  if (type === "danger") {
    return <button>Danger</button>;
  }
}
```

Every new button type requires modifying the component.

---

### ✅ OCP

```jsx
function PrimaryButton() {
  return <button>Primary</button>;
}

function SecondaryButton() {
  return <button>Secondary</button>;
}

function DangerButton() {
  return <button>Danger</button>;
}
```

Need a new button?

```jsx
function SuccessButton() {
  return <button>Success</button>;
}
```

Add a new component instead of modifying existing ones.

---

# Interview Answer

If asked:

### "Why is Open-Closed Principle important?"

You can say:

> OCP helps us add new functionality without modifying existing, tested code. This reduces the risk of introducing regressions, improves maintainability, minimizes retesting effort, and allows systems to scale by extending behavior through abstractions such as interfaces and inheritance rather than changing existing implementations.

### One-line summary

**SRP protects code from changes caused by multiple responsibilities.**

**OCP protects code from changes caused by new requirements.**
