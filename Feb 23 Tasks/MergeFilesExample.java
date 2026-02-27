import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeFilesExample {

    public static void main(String[] args) {

        try (
            BufferedWriter bw = new BufferedWriter(new FileWriter("merged.txt"));
            BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"))
        ) {

            String line;

            // Read file1 and write to merged.txt
            while ((line = br1.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            // Read file2 and write to merged.txt
            while ((line = br2.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Files merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
