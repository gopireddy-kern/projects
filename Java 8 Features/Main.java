import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<String> name = Optional.ofNullable(null);

        System.out.println(name.orElse("Default Name"));
    }

    private static Optional<String> ofNullable(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ofNullable'");
    }
}
