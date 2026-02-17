
public class UsernameGenerator {

    public static String generateUsername(String fullName) {

        fullName = fullName.toLowerCase();

        fullName = fullName.replaceAll("\\s+", "");

        fullName = fullName.replaceAll("[aeiou]", "");

        return fullName;
    }

    public static void main(String[] args) {
        String fullName = "Kern Software Solutions";
        String username = generateUsername(fullName);

        System.out.println("Generated Username: " + username);
    }
}