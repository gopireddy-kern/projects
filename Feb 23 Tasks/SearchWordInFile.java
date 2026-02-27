import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchWordInFile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word to search: ");
        String searchWord = scanner.nextLine();

        int lineNumber = 0;
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                lineNumber++;  // Increment line counter

                // Check if line contains the search word
                if (line.contains(searchWord)) {
                    System.out.println("Word found at line: " + lineNumber);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Word not found in file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
