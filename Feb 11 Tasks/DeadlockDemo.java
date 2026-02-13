
class BankAccount {

    private String name;
    private int balance;

    public BankAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void transfer(BankAccount target, int amount) {

        synchronized (this) {
            System.out.println(Thread.currentThread().getName() +
                    " locked " + this.name);

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (target) {
                System.out.println(Thread.currentThread().getName() +
                        " locked " + target.name);

                this.balance -= amount;
                target.balance += amount;

                System.out.println("Transfer successful from "
                        + this.name + " to " + target.name);
            }
        }
    }
}

public class DeadlockDemo {

    public static void main(String[] args) {

        BankAccount accountA = new BankAccount("Account-A", 5000);
        BankAccount accountB = new BankAccount("Account-B", 5000);

        Thread t1 = new Thread(() -> {
            accountA.transfer(accountB, 1000);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            accountB.transfer(accountA, 2000);
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
