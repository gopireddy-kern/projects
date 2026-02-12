import java.util.*;

interface PaymentMethod {
    void pay(double amount);
}

class UPIPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
        System.out.println("UPI Payment Successful");
    }
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment of ₹" + amount);
        System.out.println("Credit Card Payment Successful");
    }
}

class NetBankingPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Net Banking payment of ₹" + amount);
        System.out.println("Net Banking Payment Successful");
    }
}

class PaymentFactory {

    public static PaymentMethod getPaymentMethod(String type) {

        if (type.equalsIgnoreCase("UPI"))
            return new UPIPayment();
        else if (type.equalsIgnoreCase("CARD"))
            return new CreditCardPayment();
        else if (type.equalsIgnoreCase("NETBANKING"))
            return new NetBankingPayment();
        else
            throw new IllegalArgumentException("Invalid payment type");
    }
}

class TransactionLogger {

    public static void log(String message) {
        System.out.println("[TRANSACTION LOG] " + message);
    }
}

public class Task7 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter payment type (UPI / CARD / NETBANKING): ");
            String type = sc.nextLine();
            
            System.out.print("amount: ");
            double amount = sc.nextDouble();
            
            PaymentMethod payment = PaymentFactory.getPaymentMethod(type);
            
            TransactionLogger.log("Payment initiated using " + type);
            payment.pay(amount);
            TransactionLogger.log("Payment completed successfully");
        }
    }
}

