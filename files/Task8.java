

public class Task8 {
    
 public static void main(String[] args) {

        int[] serverStatus = { 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1 };

        int totalDowntime = 0;
        int longestDowntime = 0;
        int currentDowntime = 0;

        for (int status : serverStatus) {
            if (status == 0) {
                totalDowntime++;
                currentDowntime++;
                if (currentDowntime > longestDowntime) {
                    longestDowntime = currentDowntime;
                }
            } else {
                currentDowntime = 0; 
            }
        }

        System.out.println("Total Downtime Hours: " + totalDowntime);
        System.out.println("Longest Continuous Downtime: " + longestDowntime + " hours");
    }
}
