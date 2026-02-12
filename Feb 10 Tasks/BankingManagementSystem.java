
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

abstract class BankAccount {

    private final String accountNumber;
    private double balance;
    private final ArrayList<String> transactions = new ArrayList<>();

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount);
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            getTransactions().add("Withdrawn: " + amount);
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            throw new InsufficientBalanceException("Insufficient balance! Cannot withdraw from Savings Account.");
        }
    }
}
class CurrentAccount extends BankAccount {

    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            getTransactions().add("Withdrawn: " + amount);
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            throw new InsufficientBalanceException("Exceeded overdraft limit! Cannot withdraw from Current Account.");
        }
    }
}

public class BankingManagementSystem {

    private static final HashMap<String, BankAccount> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Show Account Details");
            System.out.println("6. Show Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> createSavingsAccount();
                case 2 -> createCurrentAccount();
                case 3 -> depositMoney();
                case 4 -> withdrawMoney();
                case 5 -> showAccountDetails();
                case 6 -> showTransactionHistory();
                case 7 -> {
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void createSavingsAccount() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        accounts.put(accNum, new SavingsAccount(accNum, balance));
        System.out.println("Savings Account created successfully!");
    }

    private static void createCurrentAccount() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter Overdraft Limit: ");
        double overdraft = sc.nextDouble();
        sc.nextLine();
        accounts.put(accNum, new CurrentAccount(accNum, balance, overdraft));
        System.out.println("Current Account created successfully!");
    }

    private static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount acc = accounts.get(accNum);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amt = sc.nextDouble();
            sc.nextLine();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount acc = accounts.get(accNum);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amt = sc.nextDouble();
            sc.nextLine();
            try {
                acc.withdraw(amt);
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void showAccountDetails() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount acc = accounts.get(accNum);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void showTransactionHistory() {
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        BankAccount acc = accounts.get(accNum);
        if (acc != null) {
            System.out.println("Transaction History for Account " + accNum + ":");
            for (String t : acc.getTransactions()) {
                System.out.println(t);
            }
        } else {
            System.out.println("Account not found!");
        }
    }
}
