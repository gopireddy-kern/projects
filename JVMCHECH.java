

public class JVMCHECH {
    public static void main(String[] args) {
        System.out.println( "Java Version: "+
            System.getProperty("java version"));


            System.out.println(" JVM Name: " +
                System.clearProperty( "java.vm.name") );

                System.out.println("JVM Vendor:" +
                    System.clearProperty("java.vm.vendor") );


    }
    
}
