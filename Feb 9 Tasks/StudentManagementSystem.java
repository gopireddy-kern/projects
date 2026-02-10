

class Student {

    private int id;
    private String name;
    private int marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public char calculateGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else {
            return 'C';
        }
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Student student = new Student();

        student.setId(1);
        student.setName("Rahul");
        student.setMarks(85);

        System.out.println("Student: " + student.getName());
        System.out.println("Marks: " + student.getMarks());
        System.out.println("Grade: " + student.calculateGrade());
    }
}

