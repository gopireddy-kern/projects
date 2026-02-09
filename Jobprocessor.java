public class Jobprocessor {
    
 public static void main(String[] args) {

        boolean[] records = { true, true, false, true, false, true };

        for (int i = 0; i < records.length; i++) {

            System.out.println("Processing record " + (i + 1));

            if (!records[i]) {
                System.out.println("Invalid record. Skipping...");
                continue;
            }

            if (i == 4) {
                System.out.println("Critical error encountered! Stopping job.");
                break;
            }

            System.out.println("Record processed successfully.");
        }

        System.out.println("Batch job finished.");
    }
}
