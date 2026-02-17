import java.util.HashMap;
import java.util.Map;

public class RepeatedWords {

    public static void main(String[] args) {

        String paragraph = "Java is powerful. Java is platform independent and Java is popular.";

        paragraph = paragraph.toLowerCase();

        paragraph = paragraph.replaceAll("[^a-z ]", "");

        String[] words = paragraph.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Repeated Words:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}
