

public class Task10 {
    
public static void main(String[] args) {

        int[] sourceData = { 101, 102, 103, 104, 105 };
        int[] destinationData = { 101, 102, 999, 104, 106 };

        if (sourceData.length != destinationData.length) {
            System.out.println("Arrays are not identical! Different lengths.");
            return;
        }

        boolean identical = true;

        System.out.println("Comparing source and destination data...");

        for (int i = 0; i < sourceData.length; i++) {
            if (sourceData[i] != destinationData[i]) {
                System.out.println("Mismatch at index " + i + ": source=" 
                                    + sourceData[i] + ", destination=" + destinationData[i]);
                identical = false;
            }
        }

        if (identical) {
            System.out.println("Arrays are identical. Data sync successful.");
        }
    }
}
