
import java.util.HashSet;
import java.util.Set;




public class DuplicateFinder {

    public static Set<Integer> findDuplicates(int[] arr) {
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 2, 4, 5, 3, 6, 1, 7};

        Set<Integer> duplicates = findDuplicates(numbers);

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate elements: " + duplicates);
        }
    }
}
