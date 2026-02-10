
import java.util.Arrays;

public class Anagramcheck {

    public static void main(String[] args){
        String s1 = "listen";
        String s2 = "Silent";

        //convert to lowercase
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        
        if (s1.length() !=s2.length()){
            System.out.println( "Not an anagram");
            return;

            }

            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();

            //sort both arrays
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            //compare arrays
            if (Arrays.equals(arr1,arr2) ) {
                System.out.println( "Anagram");
            } else {
                System.out.println("Not an Anagram");
        }

    }

             
    
}
