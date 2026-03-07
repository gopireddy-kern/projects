import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);

        System.out.println(set);
    }
}
