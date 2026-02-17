public class RemoveHTMLTags {

    public static void main(String[] args) {

        String input = "<h1>Hello</h1>";

        String output = input.replaceAll("<.*?>", "");

        System.out.println(output);
    }
}
