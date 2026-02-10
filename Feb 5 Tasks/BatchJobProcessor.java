

public class BatchJobProcessor {

    public static void main(String[] args) {

        int[] records = {10, 20, 0, 30, -1, 40, 50};

        System.out.println("Starting batch job processing...\n");

        for (int i = 0; i < records.length; i++) {

            int record = records[i];

            if (record == 0) {
                System.out.println("Record " + i + " is invalid. Skipping...");
                continue;
            }

            if (record == -1) {
                System.out.println("Critical error at record " + i + ". Stopping batch job!");
                break;
            }

            System.out.println("Processing record " + i + ": " + record);
        }

        System.out.println("\nBatch job completed.");
    }
}

