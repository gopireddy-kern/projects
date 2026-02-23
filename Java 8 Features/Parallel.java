import java.util.*;

public class Parallel {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        nums.parallelStream()
            .forEach(System.out::println);
    }
}
