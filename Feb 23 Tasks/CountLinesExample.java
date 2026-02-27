import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLinesExample {

    public static void main(String[] args) {

        int lineCount = 0;

        try {
            FileReader fr = new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;   // Increment counter
            }

            // Print total number of lines
            System.out.println("Total number of lines: " + lineCount);

            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
