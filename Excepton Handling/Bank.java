public class Bank {

    static void withdraw(double balance, double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance");
        } else {
            System.out.println("Withdrawal Successful");
        }
    }

    public static void main(String[] args) {

        try {
            withdraw(5000, 7000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
