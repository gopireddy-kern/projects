

public class Task9 {
    
  public static void main(String[] args) {

        int[] responseTimes = { 1200, 2500, 1800, 3000, 900, 2200, 1600 };

        int slowThreshold = 2000; 
        int totalTime = 0;

        System.out.println("Slow APIs (response time > " + slowThreshold + " ms):");

        for (int i = 0; i < responseTimes.length; i++) {
            int time = responseTimes[i];
            totalTime += time;

            if (time > slowThreshold) {
                System.out.println("API " + (i + 1) + ": " + time + " ms");
            }
        }

        double averageTime = (double) totalTime / responseTimes.length;
        System.out.println("\nAverage API Response Time: " + averageTime + " ms");
    }
}

