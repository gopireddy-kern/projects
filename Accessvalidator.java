public class Accessvalidator {
    
 public static void main(String[] args) {

        int age = 22;
        boolean hasValidID = true;
        boolean hasActiveSubscription = false;

        if (age >= 18 && hasValidID && hasActiveSubscription) {
            System.out.println("Access Granted");
        } else {
            System.out.println("Access Denied");
        }
    }
}
