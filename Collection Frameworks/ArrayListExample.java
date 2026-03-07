import java.util. *;

public class ArrayListExample{

    public static void main(String[] args) {
        
        List<String> list= new ArrayList<>();

list.add("Apple");
list.add("Banana");
list.add("Mango");
list.add("Apple");

  
System.out.println(" List Elements");
for (String fruit : list)  {
    
    System.out.println(fruit);
}

    }
}


