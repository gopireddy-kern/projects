class LogScanner extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {
            System.out.println("Scanning logs... Cycle " + i);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println("Log scanning completed.");
    }
}

public class LogMonitoringSystem {

    public static void main(String[] args) throws InterruptedException {

        LogScanner scanner = new LogScanner();

        System.out.println("Thread State (After Creation): " + scanner.getState());

        scanner.start();

        while (scanner.isAlive()) {
            System.out.println("Thread State: " + scanner.getState());
            Thread.sleep(1000);
        }

        System.out.println("Thread State (After Completion): " + scanner.getState());
    }
}