
import java.util.Scanner;

public class ApplicationMenuSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        boolean running = true;

        while (running) {
            System.out.println("\n--- Application Menu ---");
            System.out.println("1. Start Service");
            System.out.println("2. Stop Service");
            System.out.println("3. Restart Service");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Service started successfully.");
                    break;

                case 2:
                    System.out.println("Service stopped successfully.");
                    break;

                case 3:
                    System.out.println("Service restarted successfully.");
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
