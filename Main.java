import java.util.Scanner;
    
public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter product name: ");
            String productName = sc.nextLine();
            
            System.out.print("Enter price per unit: ");
            double price = sc.nextDouble();
            
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            
            double totalAmount = price * quantity;
            
            int storedAmount = (int) totalAmount;
            double precisionLoss = totalAmount - storedAmount;
            
            System.out.println("\n===== BILL DETAILS =====");
            System.out.println("Product: " + productName);
            System.out.println("Price per unit: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Amount (double): " + totalAmount);
            System.out.println("Stored Amount (int): " + storedAmount);
            System.out.println("Precision Loss: " + precisionLoss);
        }
    }
}
