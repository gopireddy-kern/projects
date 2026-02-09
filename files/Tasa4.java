

public class Tasa4 {
    
  public static void main(String[] args) {

        double[] salaries = { 50000, 60000, 45000, 70000, 55000 };

        System.out.println("Original Salaries:");
        for (double salary : salaries) {
            System.out.println(salary);
        }

        for (int i = 0; i < salaries.length; i++) {
            salaries[i] = salaries[i] + (salaries[i] * 0.10); 
        }

        System.out.println("\nUpdated Salaries after 10% hike:");
        for (double salary : salaries) {
            System.out.println(salary);
        }
    }
}
