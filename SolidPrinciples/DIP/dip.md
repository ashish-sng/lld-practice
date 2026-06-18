Perfect. DIP is usually the last SOLID principle and ties together everything you've learned about SRP, OCP, LSP, and ISP.

Most candidates memorize:

> "Depend on abstractions, not concretions."

But interviewers want to know **why**.

---

# Dependency Inversion Principle (DIP)

### Definition

> High-level modules should not depend on low-level modules. Both should depend on abstractions.
>
> Abstractions should not depend on details. Details should depend on abstractions.

Sounds complicated.

Let's simplify.

---

## Without DIP

Imagine you're building a notification system.

### File: `EmailService.java`

```java
public class EmailService {

    public void sendEmail(String message) {
        System.out.println("Sending Email: " + message);
    }
}
```

---

### File: `NotificationManager.java`

```java
public class NotificationManager {

    private EmailService emailService =
            new EmailService();

    public void send(String message) {
        emailService.sendEmail(message);
    }
}
```

---

### File: `Main.java`

```java
public class Main {

    public static void main(String[] args) {

        NotificationManager manager =
                new NotificationManager();

        manager.send("Welcome");
    }
}
```

---

# Why is this bad?

Look carefully:

```java
NotificationManager
```

is the business logic.

This is your **high-level module**.

```java
EmailService
```

is a low-level implementation detail.

Yet:

```java
private EmailService emailService =
        new EmailService();
```

means the high-level module directly depends on the low-level module.

---

## Requirement Change

Business says:

> Use SMS instead of Email.

Now you must modify:

```java
NotificationManager
```

```java
private SmsService smsService =
        new SmsService();
```

Violation.

---

## Another Problem: Testing

Suppose:

```java
EmailService
```

calls a real SMTP server.

When testing:

```java
NotificationManager
```

you don't want real emails sent.

But because it creates:

```java
new EmailService()
```

internally, you cannot easily replace it.

Testing becomes difficult.

---

# ✅ Applying DIP

Create an abstraction.

---

### File: `NotificationService.java`

```java
public interface NotificationService {

    void send(String message);
}
```

---

### File: `EmailService.java`

```java
public class EmailService
        implements NotificationService {

    @Override
    public void send(String message) {

        System.out.println(
                "Sending Email: " + message);
    }
}
```

---

### File: `SmsService.java`

```java
public class SmsService
        implements NotificationService {

    @Override
    public void send(String message) {

        System.out.println(
                "Sending SMS: " + message);
    }
}
```

---

### File: `NotificationManager.java`

```java
public class NotificationManager {

    private final NotificationService notificationService;

    public NotificationManager(
            NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    public void send(String message) {

        notificationService.send(message);
    }
}
```

---

### File: `Main.java`

```java
public class Main {

    public static void main(String[] args) {

        NotificationService notificationService =
                new EmailService();

        NotificationManager manager =
                new NotificationManager(
                        notificationService);

        manager.send("Welcome");
    }
}
```

---

# What Changed?

Before:

```java
NotificationManager
    ↓
EmailService
```

High-level depends on low-level.

---

After:

```text
NotificationManager
        ↓
NotificationService
        ↑
EmailService
SmsService
```

Now both depend on the abstraction.

---

# Why Is This Called "Dependency Inversion"?

Normal flow:

```text
Business Logic
      ↓
Database
```

```text
Notification Manager
      ↓
Email Service
```

High-level depends on low-level.

---

DIP inverts it:

```text
Notification Manager
        ↓
NotificationService
        ↑
EmailService
```

Now low-level depends on the abstraction.

Direction is inverted.

Hence:

> Dependency Inversion Principle.

---

# Why Is DIP Important?

---

## 1. Easier Changes

Before:

```java
NotificationManager
```

must change whenever notification type changes.

After:

Add:

```java
class WhatsAppService
        implements NotificationService
```

No changes to manager.

---

## 2. Easier Testing

Create:

```java
class FakeNotificationService
        implements NotificationService {

    @Override
    public void send(String message) {

        System.out.println("Fake notification");
    }
}
```

Test:

```java
NotificationManager manager =
        new NotificationManager(
                new FakeNotificationService());
```

No emails sent.

No external dependencies.

---

## 3. Better OCP

Notice:

```java
EmailService
SmsService
WhatsAppService
```

can be added freely.

That's OCP.

DIP often enables OCP.

---

# Real Spring Boot Example

This is why Spring uses constructor injection everywhere.

```java
@Service
public class UserService {

    private final UserRepository repository;

    public UserService(
            UserRepository repository) {

        this.repository = repository;
    }
}
```

Notice:

```java
UserService
```

doesn't do:

```java
new UserRepository()
```

Spring injects it.

This is DIP in action.

---

# Interview Questions

---

## Q1: Why is `new` often a DIP smell?

Example:

```java
private EmailService emailService =
        new EmailService();
```

Because the class is tightly coupled to a concrete implementation.

You lose flexibility and testability.

---

## Q2: Does DIP require interfaces?

No.

It requires abstractions.

Can be:

```java
interface
```

or

```java
abstract class
```

---

## Q3: Difference Between OCP and DIP?

### OCP

```text
Add new behavior without modifying existing code.
```

### DIP

```text
Depend on abstractions instead of concrete implementations.
```

DIP often helps achieve OCP.

---

## Q4: Difference Between ISP and DIP?

### ISP

```text
Small focused interfaces.
```

### DIP

```text
Depend on interfaces rather than concrete classes.
```

---

# Common Interview Smells

Whenever you see:

```java
new MySqlDatabase()
```

inside business logic

or

```java
new EmailService()
```

inside service classes

or

```java
new StripePaymentGateway()
```

inside payment logic

ask yourself:

> Should this dependency be injected through an abstraction?

If yes, DIP is probably being violated.

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

The most common interview question after DIP is:

> "Explain how Spring's Dependency Injection container helps implement DIP."

And the answer is:

> Spring injects implementations through abstractions (interfaces/abstract classes), preventing high-level modules from directly depending on concrete classes. This reduces coupling and improves testability and extensibility.
