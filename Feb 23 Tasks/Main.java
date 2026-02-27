import java.io.*;

class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Gopi", 88.5);

        // -------- SERIALIZATION --------
        try {
            FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(s1);

            oos.close();
            fos.close();

            System.out.println("Object Serialized Successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // -------- DESERIALIZATION --------
        try {
            FileInputStream fis = new FileInputStream("student.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student s2 = (Student) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("\nObject Deserialized Successfully!");
            s2.display();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
