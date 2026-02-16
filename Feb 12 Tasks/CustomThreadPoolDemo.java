
import java.util.concurrent.*;

class TrafficTask implements Runnable {

    private int taskId;

    public TrafficTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId +
                " handled by " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Task " + taskId + " completed.");
    }
}

public class CustomThreadPoolDemo {

    public static void main(String[] args) {

        int corePoolSize = 3;
        int maxPoolSize = 6;
        int queueCapacity = 5;

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.AbortPolicy() 
        );

        for (int i = 1; i <= 30; i++) {
            try {
                executor.execute(new TrafficTask(i));
                System.out.println("Submitted Task " + i);
            } catch (RejectedExecutionException e) {
                System.out.println("Task " + i + " rejected!");
            }
        }

        executor.shutdown();
    }
}
