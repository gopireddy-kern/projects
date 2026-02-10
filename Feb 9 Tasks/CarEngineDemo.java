
class Engine {

    private String type;
    private int horsepower;

    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    public String getType() {
        return type;
    }

    public int getHorsepower() {
        return horsepower;
    }
}

class Car {

    private String model;
    private String color;
    private Engine engine; 

    public Car(String model, String color, Engine engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    public void displayCarDetails() {
        System.out.println("Car Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Engine Type: " + engine.getType());
        System.out.println("Horsepower: " + engine.getHorsepower());
    }
}

public class CarEngineDemo {

    public static void main(String[] args) {
        Engine eng = new Engine("V8", 450);
        Car car = new Car("Mustang", "Red", eng);

        car.displayCarDetails();
    }
}

