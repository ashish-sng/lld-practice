# Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

Adapter pattern is also known as a wrapper. It works like a translation layer between our application code and a third-party system whose interface does not match what our code expects.

# Adapter Pattern in This Example

This example uses the Adapter pattern for a practical finance use case:

- our application wants a simple payment interface
- a third-party gateway like Razorpay exposes a different interface

Our application wants to do this:

```java
paymentGateway.pay(1500);
```

But the third-party API may expose something like this:

```java
razorpayApi.makePaymentInPaise(150000);
```

So there is a mismatch in:

- method name
- interface shape
- data format

The Adapter pattern helps us bridge that mismatch cleanly.

## Classes and their roles

- `PaymentGateway`
  - This is the target interface.
  - It is the interface our application understands.
  - It defines:
    - `pay(int amountInRupees)`

- `RazorpayApi`
  - This is the adaptee.
  - It represents the third-party API.
  - It exposes:
    - `makePaymentInPaise(int amountInPaise)`

- `RazorpayAdapter`
  - This is the adapter.
  - It implements `PaymentGateway`.
  - It internally calls `RazorpayApi`.
  - It also converts rupees into paise.

- `CheckoutService`
  - This is the client/business code.
  - It only depends on `PaymentGateway`.
  - It does not know Razorpay-specific details.

## How it works

In `Main`, we create the third-party object:

```java
RazorpayApi razorpayApi = new RazorpayApi();
```

Then we wrap it with the adapter:

```java
PaymentGateway paymentGateway = new RazorpayAdapter(razorpayApi);
```

Then our business code uses only the target interface:

```java
CheckoutService checkoutService = new CheckoutService(paymentGateway);
checkoutService.checkout(1500);
```

## Flow of control

When this runs:

```java
checkoutService.checkout(1500);
```

the flow is:

1. `CheckoutService` calls `paymentGateway.pay(1500)`
2. `RazorpayAdapter` receives the amount in rupees
3. The adapter converts rupees to paise
4. The adapter calls:

```java
razorpayApi.makePaymentInPaise(150000);
```

So the application keeps using its own clean interface, while the adapter handles third-party translation.

## Why this is useful

Without Adapter:

- business code becomes tightly coupled to Razorpay
- rupees-to-paise conversion may get scattered in multiple places
- replacing Razorpay with another provider becomes harder

With Adapter:

- third-party integration details stay isolated
- application code remains clean
- switching providers becomes easier
- business code depends on our interface, not vendor-specific APIs

## Why this example feels practical

This is a very real software engineering scenario.

In actual systems, third-party providers often differ in:

- method names
- request formats
- response structures
- units and field names

The Adapter pattern is commonly used to integrate:

- payment gateways
- shipping partners
- SMS providers
- email services
- tax or invoicing systems

## Interview Notes

- Definition:
  - Adapter converts one interface into another interface that the client expects.

- Intent:
  - Use it when existing code and required code cannot work together because their interfaces are different.

- Real-world signal:
  - Your business code expects one format, but a third-party SDK gives another.

- In this example:
  - `PaymentGateway` is the target
  - `CheckoutService` is the client
  - `RazorpayApi` is the adaptee
  - `RazorpayAdapter` is the adapter

- Main benefit:
  - Integration-specific changes stay in one place.

- Common interview line:
  - "Adapter is a translator between two incompatible interfaces."

- Difference from Decorator:
  - Adapter changes interface.
  - Decorator keeps the same interface and adds behavior.

- Difference from Facade:
  - Adapter makes incompatible things work together.
  - Facade provides a simplified interface over a subsystem.

- When to use:
  - Third-party API integration
  - Legacy code integration
  - Unit conversion or data-shape conversion
  - Wrapping vendor SDKs behind internal interfaces

- One strong design takeaway:
  - Your business layer should depend on your own interfaces, not directly on vendor APIs.
