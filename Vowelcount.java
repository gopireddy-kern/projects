public class Vowelcount {

            
    public static void main(String[]args){
    String str ="Hello world";
int count =0;

str=str.toLowerCase();

// to handle both upper & lower case

   for (int i =0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (ch == 'a'  || ch =='e'|| ch =='i'|| ch =='0' || ch =='u'){
        count++;
    }

}

System.out.println("Number of vowels: " + count);

   }

}