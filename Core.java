import java.io.*;
import java.util.*;

class Student implements Serializable {
    private String name;
    private int[] marks;
    private int total;
    private double average;
    private char grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateResults();
    }

    private void calculateResults() {
        total = 0;
        for (int m : marks) total += m;
        average = total / (double) marks.length;

        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 50) grade = 'D';
        else grade = 'F';
    }

    public void display() {
        System.out.printf("%-20s %-10d %-10.2f %-5c%n", name, total, average, grade);
    }
}

public class GradeCalculator {
    private static final String FILE_NAME = "results.dat";
    private static List<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();
        int choice;
        do {
            System.out.println("\n=== Grade Calculator Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Results");
            System.out.println("3. Save & Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewResults();
                case 3 -> saveData();
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (true);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        int subjects = 0;
        while (true) {
            try {
                System.out.print("Enter number of subjects: ");
                subjects = Integer.parseInt(sc.nextLine());
                if (subjects <= 0) throw new IllegalArgumentException();
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid positive number.");
            }
        }

        int[] marks = new int[subjects];
        for (int i = 0; i < subjects; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks for subject " + (i + 1) + ": ");
                    marks[i] = Integer.parseInt(sc.nextLine());
                    if (marks[i] < 0 || marks[i] > 100) throw new IllegalArgumentException();
                    break;
                } catch (Exception e) {
                    System.out.println("Marks must be between 0 and 100.");
                }
            }
        }

        students.add(new Student(name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewResults() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.printf("%-20s %-10s %-10s %-5s%n", "Name", "Total", "Average", "Grade");
        System.out.println("--------------------------------------------------");
        for (Student s : students) s.display();
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Data saved successfully. Exiting...");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Loaded " + students.size() + " student records.");
        } catch (Exception e) {
            System.out.println("Error loading data. Starting fresh.");
        }
    }
}
