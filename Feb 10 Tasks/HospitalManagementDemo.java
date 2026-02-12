import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}
class Patient extends Person {
    private String illness;
    private boolean discharged = false;
    public Patient(String name, int age, String illness) {
        super(name, age);
        this.illness = illness;
    }

    public String getIllness() { return illness; }

    public boolean isDischarged() { return discharged; }

    public void discharge() {
        discharged = true;
        System.out.println(getName() + " has been discharged.");
    }
}

class Doctor extends Person {
    private String specialization;
    private List<Patient> patients; 

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getSpecialization() { return specialization; }

    public void assignPatient(Patient patient) {
        patients.add(patient);
        System.out.println(patient.getName() + " assigned to Dr. " + getName());
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void dischargePatient(Patient patient) {
        if (patients.contains(patient)) {
            patient.discharge();
            patients.remove(patient);
        } else {
            System.out.println(patient.getName() + " is not under Dr. " + getName());
        }
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Dr. " + doctor.getName() + " added to " + name);
    }

    public void showAllDoctors() {
        System.out.println("\nDoctors in " + name + ":");
        for (Doctor d : doctors) {
            System.out.println("Dr. " + d.getName() + " - " + d.getSpecialization());
        }
    }

    public List<Doctor> searchDoctorsBySpecialization(String specialization) {
        return doctors.stream()
                .filter(d -> d.getSpecialization().equalsIgnoreCase(specialization))
                .collect(Collectors.toList());
    }
}

public class HospitalManagementDemo {

    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Hospital");

        Doctor drSmith = new Doctor("Smith", 45, "Cardiology");
        Doctor drJones = new Doctor("Jones", 38, "Neurology");
        Doctor drLee = new Doctor("Lee", 50, "Orthopedics");

        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        hospital.addDoctor(drLee);

        hospital.showAllDoctors();

        Patient p1 = new Patient("Alice", 30, "Heart Problem");
        Patient p2 = new Patient("Bob", 25, "Migraine");
        Patient p3 = new Patient("Charlie", 40, "Bone Fracture");

        drSmith.assignPatient(p1);
        drJones.assignPatient(p2);
        drLee.assignPatient(p3);
        drSmith.dischargePatient(p1);
        drSmith.dischargePatient(p1);

        System.out.println("\nSearching for Neurology doctors:");
        List<Doctor> neuroDoctors = hospital.searchDoctorsBySpecialization("Neurology");
        for (Doctor d : neuroDoctors) {
            System.out.println("Dr. " + d.getName() + " - " + d.getSpecialization());
        }
    }
}


