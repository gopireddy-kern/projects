import java.util.*;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class Company {
    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
                new Employee("Ram", 50000),
                new Employee("John", 70000),
                new Employee("Anu", 40000)
        );

        // Sort by salary using Lambda
        list.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));

        list.forEach(e -> System.out.println(e.name + " " + e.salary));
    }
}
