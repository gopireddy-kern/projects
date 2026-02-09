

public class BillingSystem {

    public static void processBill(double amount) {

        int storedAmount = (int) amount;

        if (amount != storedAmount) {
            System.out.println("Precision loss detected!");
            System.out.println("Original amount (double): " + amount);
            System.out.println("Stored amount (int): " + storedAmount);
        } else {
            System.out.println("No precision loss.");
        }

        double finalAmount = storedAmount;

        System.out.println("Final amount after implicit casting (int → double): " + finalAmount);
    }

    public static void main(String[] args) {

        double billAmount = 2599.75;

        System.out.println("Processing billing amount...");
        processBill(billAmount);
    }
}

