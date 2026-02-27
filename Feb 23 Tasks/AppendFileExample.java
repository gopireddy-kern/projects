
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class AppendFileExample {

    public static void main(String[] args) {

        try {
            // true = append mode
            FileWriter fw = new FileWriter("sample.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write("Line 6: Appending new data");
            bw.newLine();
            bw.write("Line 7: Old content is preserved");

            bw.close();
            fw.close();

            System.out.println("Data appended successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}