
class Account {

    private int balance = 5000; 

    public synchronized void withdraw(String customerName, int amount) {

        System.out.println(customerName + " is trying to withdraw ₹" + amount);

        if (balance >= amount) {
            System.out.println("Processing withdrawal for " + customerName);

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println("Withdrawal successful for " + customerName);
            System.out.println("Remaining Balance: ₹" + balance + "\n");

        } else {
            System.out.println("Insufficient Balance for " + customerName +
                    ". Available Balance: ₹" + balance + "\n");
        }
    }
}

class Customer extends Thread {

    private Account account;
    private int amount;

    public Customer(Account account, String name, int amount) {
        super(name);  
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(Thread.currentThread().getName(), amount);
    }
}

public class BankTransactionSystem {

    public static void main(String[] args) {

        Account sharedAccount = new Account();

        Customer c1 = new Customer(sharedAccount, "Customer-1", 2000);
        Customer c2 = new Customer(sharedAccount, "Customer-2", 3000);
        Customer c3 = new Customer(sharedAccount, "Customer-3", 2000);

        c1.start();
        c2.start();
        c3.start();
    }
}
