package SolidPrinciples.SRP;

// violating SRP

// This class:

// Holds employee data.
// Calculates salary.
// Saves employee data to DB.

// That's 3 responsibilities.

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Responsibility #1 - Business Logic
    public double calculateAnnualSalary() {
        return salary * 12;
    }

    // Responsibility #2 - Persistence Logic
    public void saveToDatabase() {
        System.out.println("Saving employee to database...");
        // JDBC code here
    }

    // Responsibility #3 - Data Management
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

