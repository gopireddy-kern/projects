public class MemoryExample {

    static int staticVar = 100; // Method Area

    public static void main(String[] args) {
        int localVar = 10;  // Stack

        Person p = new Person("Ravi"); // Object in Heap

        System.out.println(localVar);
        System.out.println(p.name);
    }
}

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}
