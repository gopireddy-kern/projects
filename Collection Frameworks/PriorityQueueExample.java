import java.util.*;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(30);
        queue.add(10);
        queue.add(20);

        System.out.println("Queue Elements:");
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
