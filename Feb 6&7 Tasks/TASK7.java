
    
public class TASK7 {

    public static void main(String[] args) {

        double totalCPU = 100.0;      
        double usedCPU = 75.0;

        double totalMemory = 16000.0; 
        double usedMemory = 13000.0;

        double cpuUsage = (usedCPU / totalCPU) * 100;
        double memoryUsage = (usedMemory / totalMemory) * 100;

        System.out.println("CPU Usage: " + cpuUsage + "%");
        System.out.println("Memory Usage: " + memoryUsage + "%");

        String cpuStatus = (cpuUsage < 80) ? "HEALTHY" : "CRITICAL";
        String memoryStatus = (memoryUsage < 80) ? "HEALTHY" : "CRITICAL";

        System.out.println("CPU Status: " + cpuStatus);
        System.out.println("Memory Status: " + memoryStatus);
    }
}
