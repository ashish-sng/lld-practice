# Proxy Pattern: Secure Document Access System

Proxy is a **structural design pattern** where one object stands in place of another object and **controls access** to it.

In simple words:

- client wants to use a real object
- but instead of talking to it directly, client talks to a **proxy**
- the proxy decides what should happen before or after forwarding the request

This is very common in real systems.

---

## Real-Life Industry Example

Imagine a company has an internal document portal.

Employees open files like:

- salary reports
- legal contracts
- customer agreements
- audit documents

But not every employee should see every file.

For example:

- `ADMIN` can view confidential documents
- `LEGAL` can view contract documents
- `INTERN` should not access restricted files

Also, loading the actual document may be expensive because:

- file may be large
- content may come from cloud storage
- access may need audit logging

So we place a **proxy** in front of the real document.

That proxy can:

- check authorization
- log access
- block unauthorized users
- create the real object only when needed

This is why Proxy fits naturally here.

---

## What Proxy Means in This Example

### Real object

The actual object that does the real work.

Example:

- `RealDocument`

It knows how to:

- load the actual document
- display the content

### Proxy object

The object that stands in front of the real object.

Example:

- `DocumentProxy`

It knows how to:

- check user role
- decide whether access is allowed
- create or call `RealDocument`

### Common interface

Both real object and proxy expose the same interface so the client can use either without caring.

Example:

- `Document`

This is important because the client should not need different code for proxy and real object.

---

## Core Idea

The client does this:

```java
Document document = new DocumentProxy("SalaryReport.pdf");
document.view("ADMIN");
```

The client thinks it is talking to a normal `Document`.

But actually:

1. request goes to `DocumentProxy`
2. proxy checks role and policy
3. if allowed, proxy forwards to `RealDocument`
4. if not allowed, proxy blocks access

So the proxy becomes a **gatekeeper**.

---

## Why We Use Proxy

Proxy is useful when direct access to a real object should be controlled.

Typical reasons:

- security
- lazy loading
- caching
- logging
- rate limiting
- remote access

In industry, Proxy is often used when the real object is:

- sensitive
- expensive to create
- remote
- restricted

---

## Structure of the Example

For a secure document system, a clean design is:

- `Document`
- `RealDocument`
- `DocumentProxy`
- `Main`

### `Document`

This is the common interface.

Example method:

```java
void view(String userRole);
```

### `RealDocument`

This is the actual implementation.

Responsibilities:

- load document content
- show document content

### `DocumentProxy`

This is the proxy.

Responsibilities:

- holds reference to `RealDocument`
- checks access rules
- optionally creates `RealDocument` lazily
- delegates to real object only if access is valid

### `Main`

This is client code.

It should use the proxy as if it is a document.

---

## Why This Is Better Than Direct Access

Without Proxy:

- every client must write access checks
- security logic gets duplicated
- logging gets scattered
- unauthorized access becomes easier to miss

With Proxy:

- access control stays in one place
- client code remains simple
- security rules are centralized
- future features like logging or caching become easier

---

## How It Works Step by Step

Suppose:

```java
Document document = new DocumentProxy("SalaryReport.pdf");
document.view("INTERN");
```

Flow:

1. client calls `view("INTERN")`
2. request reaches `DocumentProxy`
3. proxy checks whether `INTERN` can access the file
4. proxy sees permission is denied
5. proxy blocks access and prints a denial message
6. `RealDocument` is never called

Now consider:

```java
Document document = new DocumentProxy("SalaryReport.pdf");
document.view("ADMIN");
```

Flow:

1. request reaches proxy
2. proxy validates access
3. proxy creates `RealDocument` if needed
4. proxy delegates the call
5. `RealDocument` loads and shows the file

This is Proxy in action.

---

## Simple Mental Model

Think of Proxy like a **security guard at an office**.

- employee wants to enter a confidential room
- security guard stands at the entrance
- guard checks identity and permission
- only allowed people are sent inside

Here:

- security guard = proxy
- confidential room = real object
- employee = client

This analogy is very easy to remember in interviews.

---

## Different Types of Proxy

Proxy is not only about access control.

Common types:

### 1. Protection Proxy

Controls access based on permissions.

Example:

- only admins can view payroll documents

### 2. Virtual Proxy

Delays creation of an expensive object until it is actually needed.

Example:

- load heavy PDF content only when user clicks open

### 3. Remote Proxy

Represents an object that actually exists on another machine or service.

Example:

- local code calling a remote storage service

### 4. Caching Proxy

Stores previous results so expensive repeated work can be avoided.

Example:

- document metadata fetched once and reused

### 5. Logging / Smart Proxy

Adds extra work like logging, counting, or monitoring around access.

Example:

- log every confidential document view attempt

---

## What Makes Proxy Different from Just a Wrapper

Many patterns wrap another object, so interviewers may ask what is special here.

Proxy is special because its purpose is usually:

- control access
- manage lifecycle
- optimize usage
- hide remoteness

It is not just wrapping for style.

It is wrapping for **control**.

---

## Roles in Proxy Pattern

### Subject

The common interface used by client.

In this example:

- `Document`

### Real Subject

The actual object doing real work.

In this example:

- `RealDocument`

### Proxy

The object controlling access to the real subject.

In this example:

- `DocumentProxy`

### Client

The code using the object through the interface.

In this example:

- `Main`

---

## Interview Revision Notes

### One-line definition

Proxy provides a placeholder or representative for another object to control access to it.

### Intent

Use Proxy when you do not want the client to talk to the real object directly.

### Main benefits

- centralized access control
- lazy initialization
- better security
- easier logging and monitoring
- hides expensive or remote operations

### Main drawback

- adds extra classes
- may increase complexity
- too much logic in proxy can make it heavy

### Strong interview signal

If the problem says:

- “check permission before access”
- “delay heavy object creation”
- “hide remote service call”
- “cache repeated expensive work”

then Proxy is a strong candidate.

---

## Common Interview Questions

### 1. What is Proxy pattern?

Proxy is a structural pattern where a substitute object controls access to a real object.

### 2. Why do we need Proxy?

We need it when access to the real object must be controlled, delayed, logged, cached, or routed indirectly.

### 3. What is the difference between Proxy and the real object from the client point of view?

Usually none, because both follow the same interface.

### 4. Why is the common interface important?

It allows the client to use proxy and real object interchangeably.

### 5. Can Proxy create the real object lazily?

Yes. That is one of the most common uses of Proxy.

### 6. What is a protection proxy?

A proxy that checks permissions before allowing access.

### 7. What is a virtual proxy?

A proxy that delays creation of an expensive real object until required.

### 8. Is Proxy decided at compile time or runtime?

Usually the client interacts with the proxy at runtime through the common interface.

### 9. Does Proxy add behavior or control access?

Its primary goal is control, though it may also add logging, caching, or monitoring.

### 10. What is a real-world example?

Confidential document access, API gateway authentication, image lazy loading, remote service stubs, or caching database calls.

---

## Edge Cases and Design Questions

These are important because interviewers often ask beyond the happy path.

### 1. What if user role is invalid?

Proxy should handle unknown roles safely.

Best approach:

- deny access by default

Never allow access because role is missing or unrecognized.

### 2. What if the real document fails to load?

The proxy should not crash blindly.

Possible handling:

- catch exception
- log failure
- show safe error message

### 3. What if repeated access should not reload document?

You can keep a cached `RealDocument` inside the proxy.

This is a common optimization.

### 4. What if access rules differ by document type?

Proxy can check:

- document category
- user role
- department
- owner

This is realistic in enterprise systems.

### 5. What if every access attempt must be audited?

Proxy is a very good place to add:

- access logs
- denial logs
- timestamp
- actor identity

### 6. What if loading the real object is expensive?

Create it only when authorized and only when first needed.

That combines protection proxy and virtual proxy.

### 7. What if there are many different access rules?

Avoid putting too much business logic directly in proxy.

Better approach:

- proxy delegates authorization to a separate `AccessControlService`

This keeps proxy clean in larger systems.

### 8. What if concurrency happens?

If multiple threads can access the same proxy:

- lazy initialization should be thread-safe
- shared cache should be protected properly

This matters in production systems.

### 9. What if the document is public?

Proxy may simply allow all roles, but it can still be useful for:

- logging
- caching
- rate limiting

### 10. What if we want both authorization and caching?

A proxy can handle both, but if it becomes too heavy, responsibilities may be split across multiple layers.

---

## Proxy vs Similar Patterns

Proxy is often confused with Adapter, Decorator, and Facade.

### Proxy vs Decorator

**Similarity**

- both wrap another object
- both often keep the same interface

**Difference**

- Proxy mainly controls access or lifecycle
- Decorator mainly adds extra behavior/features

Memory trick:

- **Proxy** = control
- **Decorator** = enhance

### Proxy vs Adapter

**Similarity**

- both sit between client and another object

**Difference**

- Proxy keeps the same interface
- Adapter changes one interface into another

Memory trick:

- **Proxy** = same interface, controlled access
- **Adapter** = different interface, compatibility

### Proxy vs Facade

**Similarity**

- both stand in front of something complex

**Difference**

- Facade gives a simplified interface to a subsystem
- Proxy represents a specific object and controls access to it

Memory trick:

- **Facade** = simpler entry point
- **Proxy** = controlled representative

### Proxy vs Bridge

**Similarity**

- both use composition
- both separate responsibilities

**Difference**

- Bridge separates abstraction from implementation so both vary independently
- Proxy stands in front of a real object to control access or lifecycle

Memory trick:

- **Bridge** = split two dimensions
- **Proxy** = guard one object

---

## When to Use Proxy

Use Proxy when:

- you need authorization before access
- object creation is expensive
- the real object is remote
- repeated calls should be cached
- access should be monitored or audited

Do not force Proxy when:

- client can safely call the object directly
- there is no access/lifecycle/control problem to solve

---

## Real Industry Use Cases

Proxy appears in many real systems:

- API gateway checking authentication before backend call
- CDN proxy caching static content
- ORM lazy loading database objects
- secure document portals
- reverse proxies in distributed systems
- RPC stubs or remote service clients

This is why Proxy is very practical and interview-friendly.

---

## Final Mental Model

Remember Proxy like this:

> Client wants the real object.  
> Proxy stands in front of it and decides whether, when, and how the real object should be used.

That is the whole pattern.

---

## Quick Revision Summary

- Proxy stands in place of a real object
- both proxy and real object usually share the same interface
- proxy controls access, loading, caching, or remote interaction
- common real uses are security, lazy loading, caching, and logging
- in this example, `DocumentProxy` protects `RealDocument`

If you remember one line, remember this:

**Proxy is a controlled representative of a real object.**
