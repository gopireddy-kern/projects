class ReportGenerator extends Thread {

    private final String reportName;

    public ReportGenerator(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public void run() {
        try {
            System.out.println(reportName + " generation started by " 
                    + Thread.currentThread().getName());

            Thread.sleep(2000);

            System.out.println(reportName + " generation completed by " 
                    + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println(reportName + " interrupted.");
        }
    }
}

public class ReportGenerationSystem {

    public static void main(String[] args) {

        ReportGenerator salesReport = new ReportGenerator("Sales Report");
        ReportGenerator inventoryReport = new ReportGenerator("Inventory Report");
        ReportGenerator profitReport = new ReportGenerator("Profit Report");

        salesReport.start();
        inventoryReport.start();
        profitReport.start();

        try {
            salesReport.join();
            inventoryReport.join();
            profitReport.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All reports completed.");
    }
}
