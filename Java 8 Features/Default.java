interface Vehicle {

    default void start() {
        System.out.println("Vehicle Starting...");
    }
}

class Car implements Vehicle {}

public class Default {
    public static void main(String[] args) {

        Car car = new Car();
        car.start();
    }
}
