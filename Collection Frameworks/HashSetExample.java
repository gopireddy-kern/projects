import java. util.* ;


public class HashSetExample{
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Red");
        set.add("Blue");
        set.add("Green");
        set.add("Red");

        System.out.println("Set Elements:");
        for(String color : set) {
            System.out.println(color);
        }

    }
}
