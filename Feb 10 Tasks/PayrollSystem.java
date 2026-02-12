
import java.util.*;

interface Employee {
    String getName();
    double calculateSalary();
    String getType();
}

class FullTimeEmployee implements Employee {
    private String name;
    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary; 
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getType() { return "Full-Time"; }
}

class PartTimeEmployee implements Employee {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getType() { return "Part-Time"; }
}

class ContractEmployee implements Employee {
    private String name;
    private double contractAmount;

    public ContractEmployee(String name, double contractAmount) {
        this.name = name;
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculateSalary() {
        return contractAmount; 
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getType() { return "Contract"; }
}

class EmployeeBuilder {
    private String name;
    private double monthlySalary;
    private double hourlyRate;
    private int hoursWorked;
    private double contractAmount;
    private String type;

    public EmployeeBuilder setName(String name) {
        this.name = name; return this;
    }
    public EmployeeBuilder setMonthlySalary(double salary) {
        this.monthlySalary = salary; return this;
    }
    public EmployeeBuilder setHourlyRate(double rate) {
        this.hourlyRate = rate; return this;
    }
    public EmployeeBuilder setHoursWorked(int hours) {
        this.hoursWorked = hours; return this;
    }
    public EmployeeBuilder setContractAmount(double amount) {
        this.contractAmount = amount; return this;
    }
    public EmployeeBuilder setType(String type) {
        this.type = type; return this;
    }

    public Employee build() {
        switch (type) {
            case "Full-Time":
                return new FullTimeEmployee(name, monthlySalary);
            case "Part-Time":
                return new PartTimeEmployee(name, hourlyRate, hoursWorked);
            case "Contract":
                return new ContractEmployee(name, contractAmount);
            default:
                throw new IllegalArgumentException("Invalid employee type");
        }
    }
}

public class PayrollSystem {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new EmployeeBuilder()
                .setName("Alice")
                .setMonthlySalary(50000)
                .setType("Full-Time")
                .build());

        employees.add(new EmployeeBuilder()
                .setName("Bob")
                .setHourlyRate(500)
                .setHoursWorked(100)
                .setType("Part-Time")
                .build());

        employees.add(new EmployeeBuilder()
                .setName("Charlie")
                .setContractAmount(60000)
                .setType("Contract")
                .build());

        System.out.println("----- Payroll Report -----");
        for (Employee e : employees) {
            System.out.println("Name: " + e.getName() +
                               ", Type: " + e.getType() +
                               ", Salary: ₹" + e.calculateSalary());
        }
    }
}

