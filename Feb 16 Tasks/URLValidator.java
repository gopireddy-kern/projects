public class URLValidator {

    public static boolean isValidURL(String url) {
        return url.startsWith("http://") || url.startsWith("https://");
    }

    public static void main(String[] args) {

        String url1 = "https://example.com";
        String url2 = "ftp://example.com";

        System.out.println(url1 + " -> " + isValidURL(url1));
        System.out.println(url2 + " -> " + isValidURL(url2));
    }
}
