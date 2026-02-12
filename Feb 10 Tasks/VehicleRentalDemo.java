
import java.util.*;

abstract class Vehicle {

    private String id;
    private String model;
    private double basePrice;

    public Vehicle(String id, String model, double basePrice) {
        this.id = id;
        this.model = model;
        this.basePrice = basePrice;
    }

    public abstract double calculateRentalPrice(int days);

    public String getId() { return id; }
    public String getModel() { return model; }
    public double getBasePrice() { return basePrice; }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Model: " + model + ", Base Price: ₹" + basePrice);
    }
}

class Car extends Vehicle {

    public Car(String id, String model, double basePrice) {
        super(id, model, basePrice);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePrice() * days; 
    }
}

class Bike extends Vehicle {

    public Bike(String id, String model, double basePrice) {
        super(id, model, basePrice);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePrice() * days * 0.8; 
    }
}

class Truck extends Vehicle {

    public Truck(String id, String model, double basePrice) {
        super(id, model, basePrice);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getBasePrice() * days * 1.5; 
    }
}

class RentalSystem {

    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle findVehicleById(String id) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public void displayAllVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle v : vehicles) {
            v.displayDetails();
        }
    }

    public void rentVehicle(String id, int days) {
        Vehicle v = findVehicleById(id);
        if (v != null) {
            double price = v.calculateRentalPrice(days);
            System.out.println("Vehicle rented: " + v.getModel() + " for " + days + " days. Total Price: ₹" + price);
        } else {
            System.out.println("Vehicle ID not found!");
        }
    }
}

public class VehicleRentalDemo {

    public static void main(String[] args) {

        RentalSystem rentalSystem = new RentalSystem();

        rentalSystem.addVehicle(new Car("C001", "Honda City", 2000));
        rentalSystem.addVehicle(new Bike("B001", "Yamaha R15", 800));
        rentalSystem.addVehicle(new Truck("T001", "Tata Truck", 5000));

        rentalSystem.displayAllVehicles();

        System.out.println();

        rentalSystem.rentVehicle("C001", 3); 
        rentalSystem.rentVehicle("B001", 2); 
        rentalSystem.rentVehicle("T001", 1); 
        rentalSystem.rentVehicle("X001", 1); 
    }
}
