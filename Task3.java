

public class Task3 {
    
 public static void main(String[] args) {

        int[] failedAttempts = { 1, 2, 4, 3, 5 }; 
        String[] users = { "Alice", "Bob", "Charlie", "David", "Eve" };

        for (int i = 0; i < failedAttempts.length; i++) {
            System.out.println("User: " + users[i] + ", Failed Attempts: " + failedAttempts[i]);

            if (failedAttempts[i] > 3) {
                System.out.println("ALERT! User " + users[i] + " has exceeded 3 failed login attempts.");
            }
        }
    }
}
