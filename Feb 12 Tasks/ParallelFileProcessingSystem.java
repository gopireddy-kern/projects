import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FileProcessor implements Runnable {

    private String fileName;

    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Processing " + fileName +
                " by " + Thread.currentThread().getName());

        try {

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(fileName + " interrupted.");
        }

        System.out.println("Completed " + fileName +
                " by " + Thread.currentThread().getName());
    }
}

public class ParallelFileProcessingSystem {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("Submitting file processing tasks...\n");

        for (int i = 1; i <= 5; i++) {
            executor.submit(new FileProcessor("File-" + i + ".txt"));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("\nAll files processed. Executor terminated.");
    }
}
