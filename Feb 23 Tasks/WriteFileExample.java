import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class WriteFileExample {

    public static void main(String[] args) {

        try {
            // FileWriter in overwrite mode (default false for append)
            FileWriter fw = new FileWriter("sample.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);

            // Writing 5 lines
            bw.write("Line 1: Java is powerful");
            bw.newLine();
            bw.write("Line 2: File handling is easy");
            bw.newLine();
            bw.write("Line 3: BufferedWriter improves performance");
            bw.newLine();
            bw.write("Line 4: Overwriting old content");
            bw.newLine();
            bw.write("Line 5: End of file");

            // Close resources
            bw.close();
            fw.close();

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
