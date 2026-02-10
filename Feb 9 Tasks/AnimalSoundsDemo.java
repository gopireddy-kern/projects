

class Animal {

    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}
class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Dog says: Woof Woof");
    }
}


class Cat extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Cat says: Meow Meow");
    }
}

public class AnimalSoundsDemo {

    public static void main(String[] args) {

        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.makeSound();  
        animal2.makeSound();  
    }
}
