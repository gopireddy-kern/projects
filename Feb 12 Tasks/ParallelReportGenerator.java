import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ReportTask implements Callable<String> {

    private final String reportName;

    public ReportTask(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String call() throws Exception {

        System.out.println(Thread.currentThread().getName() +
                " generating " + reportName);

        Thread.sleep(2000);

        return reportName + " generated successfully";
    }
}


public class ParallelReportGenerator {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
                new ReportTask("Sales Report"),
                new ReportTask("Inventory Report"),
                new ReportTask("Finance Report"),
                new ReportTask("Customer Report"),
                new ReportTask("Audit Report")
        );

        try {

            List<Future<String>> results = executor.invokeAll(tasks);

            System.out.println("\n📋 REPORT SUMMARY:");
            System.out.println("----------------------------");

            for (Future<String> future : results) {
                System.out.println(future.get());
            }

        } catch (InterruptedException | ExecutionException e) {
        } finally {
            executor.shutdown();
        }
    }
}
