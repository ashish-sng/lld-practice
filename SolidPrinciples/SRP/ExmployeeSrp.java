package SolidPrinciples.SRP;

class SalaryCalculator {

    public double calculateAnnualSalary(ExmployeeSrp employee) {
        return employee.getMonthlySalary() * 12;
    }
}

class EmployeeRepository {

    public void save(ExmployeeSrp employee) {
        System.out.println(
            "Saving employee " + employee.getName() + " to database..."
        );

        // JDBC / JPA code here
    }
}

public class ExmployeeSrp {
    private String name;
    private double monthlySalary;

    public ExmployeeSrp(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }
}
