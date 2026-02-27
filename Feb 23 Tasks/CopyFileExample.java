import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileExample {

    public static void main(String[] args) {

        try (
            BufferedReader br = new BufferedReader(new FileReader("source.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("destination.txt"))
        ) {

            String line;

            // Read source file line by line
            while ((line = br.readLine()) != null) {

                // Write each line into destination file
                bw.write(line);

                // Move to next line
                bw.newLine();
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
