
@FunctionalInterface
interface Calculator {
    int add(int a, int b);   // only one abstract method
}

public class Demo {
    public static void main(String[] args) {
        Calculator c = (a, b) -> a + b;  // Lambda expression
        System.out.println(c.add(5, 3));
    }
}


