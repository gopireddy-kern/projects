
import java.util.Scanner;





public class Armstrongnumber {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    System.out.print(  "Enter a number; ");
        int num = sc.nextInt();

        int original = num;
        int sum = 0;
        int digits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;

      }

      if (sum == original) {
        System.out.println(" Armstrong Number"); 
      }  else {
         System.out.println("Not an Armstrong Number");
      }

    }
    

    

        
    
}
