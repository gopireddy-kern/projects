public class CamelCaseConverter {

    public static void main(String[] args) {

        String sentence = "java string programs";

        sentence = sentence.toLowerCase();

        String[] words = sentence.split("\\s+");

        StringBuilder camelCase = new StringBuilder();

        camelCase.append(words[0]);

        for (int i = 1; i < words.length; i++) {
            camelCase.append(
                words[i].substring(0, 1).toUpperCase()
                + words[i].substring(1)
            );
        }

        System.out.println("CamelCase: " + camelCase.toString());
    }
}
