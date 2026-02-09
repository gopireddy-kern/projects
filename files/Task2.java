

public class Task2 {
    
 public static void main(String[] args) {

        double[] cpuLoads = { 65.5, 70.2, 55.0, 80.1, 60.4, 75.6, 68.3 };

        double maxLoad = cpuLoads[0];
        double minLoad = cpuLoads[0];
        double sum = 0;

        for (double load : cpuLoads) {
            if (load > maxLoad) {
                maxLoad = load;
            }
            if (load < minLoad) {
                minLoad = load;
            }
            sum += load;
        }

        double averageLoad = sum / cpuLoads.length;

        System.out.println("CPU Loads for 7 days:");
        for (int i = 0; i < cpuLoads.length; i++) {
            System.out.println("Day " + (i + 1) + ": " + cpuLoads[i] + "%");
        }

        System.out.println("\nHighest CPU Load: " + maxLoad + "%");
        System.out.println("Lowest CPU Load: " + minLoad + "%");
        System.out.println("Average CPU Load: " + averageLoad + "%");
    }
}
