import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CountWordsExample {

    public static void main(String[] args) {

        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {

                // Split line into words using space
                String[] words = line.split(" ");

                // Add number of words in this line
                wordCount += words.length;
            }

            // Print total words
            System.out.println("Total number of words: " + wordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
