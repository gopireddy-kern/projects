public class FileExtensionExtractor {

    public static void main(String[] args) {

        String fileName = "photo.png";

        int dotIndex = fileName.lastIndexOf(".");

        if (dotIndex != -1 && dotIndex != fileName.length() - 1) {
            String extension = fileName.substring(dotIndex + 1);
            System.out.println("Extension: " + extension);
        } else {
            System.out.println("No extension found");
        }
    }
}
