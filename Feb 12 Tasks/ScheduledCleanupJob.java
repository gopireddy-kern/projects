import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledCleanupJob {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);
        Runnable cleanupTask = () -> {
            System.out.println("Cleaning temporary files... "
                    + Thread.currentThread().getName()
                    + " | Time: " + System.currentTimeMillis());
        };

        System.out.println("Starting scheduled cleanup job...\n");

        scheduler.scheduleAtFixedRate(
                cleanupTask,
                0,              
                5,              
                TimeUnit.SECONDS
        );

        scheduler.schedule(() -> {
            System.out.println("\nStopping cleanup job...");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}

