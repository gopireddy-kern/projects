public class LogAnalyzer {

    public static void main(String[] args) {

        String logs = """
                INFO Application started
                ERROR Database connection failed
                INFO User logged in
                ERROR File not found
                WARNING Low memory
                ERROR Timeout occurred
                """;

        String[] lines = logs.split("\\n");

        int errorCount = 0;

        for (String line : lines) {
            if (line.contains("ERROR")) {
                errorCount++;
            }
        }

        System.out.println("Total ERROR lines: " + errorCount);
    }
}
