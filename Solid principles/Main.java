class Bird {
    public void makeSound() {
        System.out.println("Bird sound");
    }
}

class Sparrow extends Bird {
    @Override
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird bird = new Sparrow();
        bird.makeSound();
    }
}
