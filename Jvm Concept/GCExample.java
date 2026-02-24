public class GCExample {

    public static void main(String[] args) {

        GCExample obj1 = new GCExample();
        GCExample obj2 = new GCExample();

        obj1 = null;
        obj2 = null;

        System.gc(); // Request GC

        System.out.println("Objects eligible for GC");
    }

    @Override
    protected void finalize() {
        System.out.println("Garbage Collected");
    }
}
