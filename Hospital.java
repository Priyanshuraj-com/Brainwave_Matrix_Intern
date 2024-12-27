import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String contact;

    public Patient(int id, String name, int age, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Contact: " + contact;
    }
}

class Appointment {
    int appointmentId;
    int patientId;
    String doctor;
    String date;
    String time;

    public Appointment(int appointmentId, int patientId, String doctor, String date, String time) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Doctor: " + doctor + ", Date: " + date + ", Time: " + time;
    }
}

class HospitalManagementSystem {
    List<Patient> patients = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();

    void registerPatient(int id, String name, int age, String contact) {
        patients.add(new Patient(id, name, age, contact));
        System.out.println("Patient registered successfully.");
    }

    void scheduleAppointment(int appointmentId, int patientId, String doctor, String date, String time) {
        boolean patientExists = patients.stream().anyMatch(p -> p.id == patientId);
        if (patientExists) {
            appointments.add(new Appointment(appointmentId, patientId, doctor, date, time));
            System.out.println("Appointment scheduled successfully.");
        } else {
            System.out.println("Patient ID not found. Please register the patient first.");
        }
    }

    void viewPatients() {
        System.out.println("\nList of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    void viewAppointments() {
        System.out.println("\nList of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalManagementSystem system = new HospitalManagementSystem();

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View Patients");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    system.registerPatient(id, name, age, contact);
                    break;
                case 2:
                    System.out.print("Enter Appointment ID: ");
                    int appointmentId = scanner.nextInt();
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Doctor Name: ");
                    String doctor = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Time (HH:MM): ");
                    String time = scanner.nextLine();
                    system.scheduleAppointment(appointmentId, patientId, doctor, date, time);
                    break;
                case 3:
                    system.viewPatients();
                    break;
                case 4:
                    system.viewAppointments();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
