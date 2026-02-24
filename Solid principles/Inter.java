interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing...");
    }
}

public class Inter {
    public static void main(String[] args) {
        Printer printer = new SimplePrinter();
        printer.print();
    }
}
