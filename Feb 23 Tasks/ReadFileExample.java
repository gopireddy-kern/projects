import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileExample {

    public static void main(String[] args) {

        try {
            // Step 1: Create FileReader (connects to file)
            FileReader fr = new FileReader("sample.txt");

            // Step 2: Wrap FileReader with BufferedReader (for efficient reading)
            BufferedReader br = new BufferedReader(fr);

            String line;

            // Step 3: Read file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}