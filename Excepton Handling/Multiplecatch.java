public class Multiplecatch {
    public static void main(String[] args) {

        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Null value found!");
        } catch (Exception e) {
            System.out.println("General Exception");
        }

        System.out.println("End of program");
    }
}
