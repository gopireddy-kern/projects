
class Employee {

    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Developer extends Employee {

    public Developer(String name, double salary) {
        super(name, salary); 
    }
}

class Manager extends Employee {

    public Manager(String name, double salary) {
        super(name, salary); 
    }
}

public class InheritanceDemo {

    public static void main(String[] args) {

        Developer dev = new Developer("Rahul", 60000);
        Manager mgr = new Manager("Anita", 80000);

        System.out.println("Developer Details:");
        dev.displayDetails();   

        System.out.println("\nManager Details:");
        mgr.displayDetails();   
    }
}

