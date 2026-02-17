import java.util.Random;
import java.util.Scanner;

public class OTPVerification {

    public static void main(String[] args) {

        Random random = new Random();
        int otpNumber = 100000 + random.nextInt(900000);
        String generatedOTP = String.valueOf(otpNumber);

        System.out.println("Generated OTP: " + generatedOTP); 

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter OTP: ");
        String enteredOTP = scanner.nextLine();

        if (generatedOTP.equals(enteredOTP)) {
            System.out.println("OTP Verified Successfully ✅");
        } else {
        }

        scanner.close();
    }
}

