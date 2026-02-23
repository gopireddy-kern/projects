interface MathUtils {
    static int square(int x) {
        return x * x;
    }
}

public class Static {
    public static void main(String[] args) {

        System.out.println(MathUtils.square(5));
    }
}
