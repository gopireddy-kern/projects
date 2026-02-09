

public class Task6 {
    
 public static void main(String[] args) {

        int[] marks = { 85, 92, 76, 105, 58, -5, 67, 49 };

        int passCount = 0;
        int failCount = 0;

        System.out.println("Student Marks Validation:");

        for (int i = 0; i < marks.length; i++) {

            int mark = marks[i];
            System.out.print("Student " + (i + 1) + ": " + mark + " - ");

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark!");
                continue;  
            }

            if (mark >= 50) {
                System.out.println("Pass");
                passCount++;
            } else {
                System.out.println("Fail");
                failCount++;
            }
        }

        System.out.println("\nTotal Passed Students: " + passCount);
        System.out.println("Total Failed Students: " + failCount);
    }
}
