import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RequestTask implements Runnable {

    private final int requestId;

    public RequestTask(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() +
                    " processed request " + requestId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class HighLoadSimulation {

    private static final int TOTAL_REQUESTS = 100;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("===== Using Fixed Thread Pool (10 Threads) =====");

        long startPool = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= TOTAL_REQUESTS; i++) {
            executor.submit(new RequestTask(i));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endPool = System.currentTimeMillis();

        System.out.println("Time Taken with Thread Pool: "
                + (endPool - startPool) + " ms\n");


        System.out.println("===== Using 100 Individual Threads =====");

        long startThreads = System.currentTimeMillis();

        Thread[] threads = new Thread[TOTAL_REQUESTS];

        for (int i = 0; i < TOTAL_REQUESTS; i++) {
            threads[i] = new Thread(new RequestTask(i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endThreads = System.currentTimeMillis();

        System.out.println("Time Taken with 100 Threads: "
                + (endThreads - startThreads) + " ms");
    }
}
