package SolidPrinciples.SRP;

public class main {
    public static void main(String[] args) {

        ExmployeeSrp employee =
            new ExmployeeSrp("Ashish", 100000);

        SalaryCalculator calculator =
            new SalaryCalculator();

        EmployeeRepository repository =
            new EmployeeRepository();

        double annualSalary =
            calculator.calculateAnnualSalary(employee);

        System.out.println("Annual Salary: " + annualSalary);

        repository.save(employee);
    }
}
