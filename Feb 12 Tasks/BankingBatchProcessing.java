import java.util.*;
import java.util.concurrent.*;

class InterestCalculator implements Callable<String> {

    private String accountNumber;
    private double balance;
    private double rate;

    public InterestCalculator(String accountNumber, double balance, double rate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.rate = rate;
    }

    @Override
    public String call() throws Exception {

        System.out.println("Calculating interest for Account: " 
                + accountNumber + 
                " by " + Thread.currentThread().getName());

        Thread.sleep(2000);

        double interest = (balance * rate) / 100;

        return "Account: " + accountNumber + 
               " | Interest: ₹" + interest;
    }
}

public class BankingBatchProcessing {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<String>> results = new ArrayList<>();

        results.add(executor.submit(
                new InterestCalculator("ACC101", 10000, 5)));
        results.add(executor.submit(
                new InterestCalculator("ACC102", 20000, 6)));
        results.add(executor.submit(
                new InterestCalculator("ACC103", 15000, 4)));
        results.add(executor.submit(
                new InterestCalculator("ACC104", 30000, 7)));

        System.out.println("All tasks submitted...\n");

        for (Future<String> future : results) {
            try {
                String result = future.get();
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        System.out.println("\nBatch Processing Completed.");
    }
}

