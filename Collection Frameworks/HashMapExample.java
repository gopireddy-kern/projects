import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "John");
        map.put(2, "Alice");
        map.put(3, "Bob");
        map.put(2, "David");   

        System.out.println("Map Elements:");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
