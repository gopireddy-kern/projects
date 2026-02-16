import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(String user, int amount) {
        System.out.println(user + " attempting to withdraw ₹" + amount);

        if (balance >= amount) {
            System.out.println(user + " processing...");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
            }
            balance -= amount;
            System.out.println("✅ " + user + " withdrawal successful. Remaining Balance: ₹" + balance);
        } else {
            System.out.println("x" + user + " insufficient balance. Current Balance: ₹" + balance);
        }
        System.out.println("----------------------------------");
    }

    public synchronized void deposit(String user, int amount) {
        System.out.println(user + " depositing ₹" + amount);
        balance += amount;
        System.out.println("💰 Deposit successful. New Balance: ₹" + balance);
        System.out.println("----------------------------------");
    }
}
class ATMUser implements Runnable {

    private final BankAccount account;
    private final String userName;
    private final int amount;

    public ATMUser(BankAccount account, String userName, int amount) {
        this.account = account;
        this.userName = userName;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(userName, amount);
    }
}


public class ATMSimulation {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new ATMUser(account, "User-1", 3000));
        executor.submit(new ATMUser(account, "User-2", 4000));
        executor.submit(new ATMUser(account, "User-3", 2000));
        executor.submit(new ATMUser(account, "User-4", 5000));
        executor.submit(new ATMUser(account, "User-5", 1000));

        executor.shutdown();
    }
}
