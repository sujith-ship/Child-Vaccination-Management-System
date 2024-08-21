import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Child {
    String name;
    String parentName;
    String vaccinationDate;

    public Child(String name, String parentName, String vaccinationDate) {
        this.name = name;
        this.parentName = parentName;
        this.vaccinationDate = vaccinationDate;
    }

    @Override
    public String toString() {
        return "Child Name: " + name + ", Parent Name: " + parentName + ", Vaccination Date: " + vaccinationDate;
    }
}

class VaccinationSystem {
    private List<Child> children;

    public VaccinationSystem() {
        children = new ArrayList<>();
    }

    public void addChild(String name, String parentName, String vaccinationDate) {
        Child child = new Child(name, parentName, vaccinationDate);
        children.add(child);
        System.out.println("Child added successfully!");
    }

    public void viewChildren() {
        if (children.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Child child : children) {
                System.out.println(child);
            }
        }
    }

    public void scheduleAppointment(String name, String parentName, String date) {
        for (Child child : children) {
            if (child.name.equalsIgnoreCase(name) && child.parentName.equalsIgnoreCase(parentName)) {
                child.vaccinationDate = date;
                System.out.println("Appointment scheduled for " + name + " (Parent: " + parentName + ") on " + date);
                return;
            }
        }
        System.out.println("Child not found.");
    }

    public void sendReminders() {
        for (Child child : children) {
            System.out.println("Reminder: " + child.name + " (Parent: " + child.parentName + ") has a vaccination appointment on " + child.vaccinationDate);
        }
    }
}

public class VaccinationApp {
    public static void main(String[] args) {
        VaccinationSystem system = new VaccinationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nVaccination Appointment System");
            System.out.println("1. Add Child");
            System.out.println("2. View Children");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Send Reminders");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter child's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter parent's name: ");
                    String parentName = scanner.nextLine();
                    System.out.print("Enter vaccination date: ");
                    String date = scanner.nextLine();
                    system.addChild(name, parentName, date);
                    break;
                case 2:
                    system.viewChildren();
                    break;
                case 3:
                    System.out.print("Enter child's name to schedule appointment: ");
                    String childName = scanner.nextLine();
                    System.out.print("Enter parent's name: ");
                    String parent = scanner.nextLine();
                    System.out.print("Enter new vaccination date: ");
                    String newDate = scanner.nextLine();
                    system.scheduleAppointment(childName, parent, newDate);
                    break;
                case 4:
                    system.sendReminders();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
