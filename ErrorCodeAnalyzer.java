

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeAnalyzer {

    public static void main(String[] args) {

        int[] errorCodes = {404, 500, 404, 403, 500, 500, 401, 404};

        Map<Integer, Integer> errorCountMap = new HashMap<>();

        for (int code : errorCodes) {
            errorCountMap.put(code, errorCountMap.getOrDefault(code, 0) + 1);
        }

        System.out.println("Error Code Counts:");
        for (Map.Entry<Integer, Integer> entry : errorCountMap.entrySet()) {
            System.out.println("Error Code " + entry.getKey() +
                               " → " + entry.getValue() + " times");
        }

        int mostFrequentCode = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : errorCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentCode = entry.getKey();
            }
        }

        System.out.println("\nMost Frequent Error Code:");
        System.out.println("Error Code " + mostFrequentCode +
                           " occurred " + maxCount + " times");
    }
}
