public class Retrymechanism {
    
 public static void main(String[] args) {

        int maxRetries = 3;
        int attempt = 1;
        boolean success = false;

        while (attempt <= maxRetries) {

            System.out.println("Attempt " + attempt + " to call API...");

            success = callApi();

            if (success) {
                System.out.println("API call successful!");
                break; 
            } else {
                System.out.println("API call failed. Retrying...");
            }

            attempt++;
        }

        if (!success) {
            System.out.println("API call failed after " + maxRetries + " attempts.");
        }
    }

    static boolean callApi() {
        return Math.random() > 0.6;
    }
}

