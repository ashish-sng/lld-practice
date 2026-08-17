# Facade Pattern: E-Commerce Order Processing System

The **Facade Pattern** provides a simplified, high-level interface to a complex set of interfaces in a subsystem. It hides the complexity of subsystem interactions from the client.

---

## 🎯 The Real-World Problem

When a customer places an order on an e-commerce platform (like Amazon or Flipkart), multiple background subsystems must work together:

1. **Inventory Management**: Check product availability and reserve stock.
2. **Payment Processing**: Validate and charge the customer's account.
3. **Shipping & Logistics**: Schedule delivery with a courier and generate a tracking number.
4. **Customer Notifications**: Send email or SMS confirmation with receipt and tracking details.

---

## ❌ Without the Facade Pattern

If the client code (e.g. `Main.java` or API Controller) handles these steps directly:
- The client becomes tightly coupled to 4+ separate services.
- The client must remember the exact execution sequence.
- Any change in subsystem signature breaks client code everywhere.

---

## ✅ With the Facade Pattern

The client communicates **only** with a unified `OrderProcessingFacade` class:

```
[ Client (Main.java) ]
        │
        ▼
┌──────────────────────────────────────────────┐
│            OrderProcessingFacade             │
└───────┬──────────────┬───────────────┬───────┘
        │              │               │
        ▼              ▼               ▼
┌──────────────┐ ┌──────────────┐ ┌──────────────┐ ┌─────────────────────┐
│ InventorySvc │ │ PaymentGtwy  │ │ ShippingSvc  │ │ NotificationService │
└──────────────┘ └──────────────┘ └──────────────┘ └─────────────────────┘
```

The client calls **one simple method**:
```java
orderProcessingFacade.placeOrder("PROD-101", 2, 499.99, "ACC-987", "123 Main St", "user@example.com");
```

---

## 🛠️ Step-by-Step Practice Guide

### 1. Subsystems
Create individual service classes with single-purpose methods:
- `InventoryService.java`: `checkStock(productId, qty)`, `reserveStock(productId, qty)`
- `PaymentGateway.java`: `processPayment(accountId, amount)`
- `ShippingService.java`: `scheduleDelivery(productId, qty, address)`
- `NotificationService.java`: `sendConfirmation(email, trackingId)`

### 2. Facade
Create `OrderProcessingFacade.java`:
- Holds references to all 4 subsystem objects.
- Exposes `placeOrder(...)` which coordinates the entire workflow step-by-step.

### 3. Client
Use `OrderProcessingFacade` in `Main.java` to place orders cleanly.
```
