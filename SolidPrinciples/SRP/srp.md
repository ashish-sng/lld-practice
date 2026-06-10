Single Responsibility Principle states that a class should have only one reason to change.

In the bad example:

Employee

had three reasons to change:

Employee data changes
Salary calculation changes
Database implementation changes

After refactoring:

Employee            -> Employee data
SalaryCalculator    -> Salary calculations
EmployeeRepository  -> Database operations

Each class now has one responsibility and one reason to change, which follows SRP. This makes the code easier to maintain, test, and extend.

SRP is important because **change is the biggest source of bugs** in software.

The more responsibilities a class has, the more likely a change for one reason accidentally breaks functionality related to another reason.

### Example: Without SRP

```java
class Employee {
    private String name;
    private double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    public void saveToDatabase() {
        System.out.println("Saving to MySQL");
    }
}
```

---

### Requirement Change #1

Management says:

> We now store employees in MongoDB instead of MySQL.

Developer modifies:

```java
public void saveToDatabase() {
    System.out.println("Saving to MongoDB");
}
```

Seems harmless.

---

### Requirement Change #2

Now salary calculation becomes:

```java
public double calculateAnnualSalary() {
    return monthlySalary * 12 + 50000; // bonus added
}
```

Again, modifying the same class.

---

### Requirement Change #3

A developer refactors the class and accidentally changes:

```java
public double calculateAnnualSalary() {
    return monthlySalary * 10; // bug!
}
```

because they were working on database code and salary logic lives in the same class.

Now payroll is broken even though the original task was database-related.

---

## Real-World Example

Imagine a React component:

```jsx
function UserProfile() {
  // Fetch API
  // Validate form
  // Handle UI rendering
  // Analytics tracking
  // Permission checks
}
```

One day someone changes analytics tracking.

Suddenly form validation stops working.

Why?

Because everything is coupled together in one giant component.

This is exactly what SRP tries to prevent.

---

## Benefits of SRP

### 1. Fewer Bugs

Changing database code cannot affect salary code because they're in different classes.

```java
EmployeeRepository
```

cannot accidentally break

```java
SalaryCalculator
```

---

### 2. Easier Testing

Without SRP:

```java
Employee employee = new Employee(...);
```

To test salary calculation, you also carry database logic.

With SRP:

```java
SalaryCalculator calculator = new SalaryCalculator();
```

You can test salary calculations independently.

---

### 3. Easier Maintenance

Suppose tomorrow:

* MySQL → MongoDB
* MongoDB → PostgreSQL

Only:

```java
EmployeeRepository
```

changes.

Everything else remains untouched.

---

### 4. Better Team Collaboration

Backend Developer A:

```java
SalaryCalculator
```

Backend Developer B:

```java
EmployeeRepository
```

They can work independently without merge conflicts in the same class.

---

## The strongest interview answer

When asked *"Why is SRP important?"*, say:

> SRP reduces coupling by ensuring a class has only one reason to change. This minimizes the risk of unrelated changes introducing bugs, makes testing easier, improves maintainability, and allows different parts of the system to evolve independently.

That's the practical reason SRP exists—not because "SOLID says so," but because it makes change safer.
