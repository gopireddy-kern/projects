public class CSVFormatter {

    public static void main(String[] args) {

        String csvData = "101,Ravi,50000";

        String[] parts = csvData.split(",");

        String formattedOutput = "ID:" + parts[0] +
                                 " Name:" + parts[1] +
                                 " Salary:" + parts[2];

        System.out.println(formattedOutput);
    }
}
