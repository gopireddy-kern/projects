import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) {

        try {
            File file = new File("sample.txt");

            if (file.exists()) {
                System.out.println("File already exists.");
            } else {
                file.createNewFile();
                System.out.println("File created successfully.");
            }

            System.out.println("Absolute Path: " + file.getAbsolutePath());

            System.out.println("File Size: " + file.length() + " bytes");

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
