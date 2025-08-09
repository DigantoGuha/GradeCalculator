import java.util.*;

class Student {
    String name;
    int[] marks;
    int total;
    double average;
    char grade;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateResults();
    }

    void calculateResults() {
        total = 0;
        for (int m : marks) {
            total += m;
        }
        average = total / (double) marks.length;

        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 50) grade = 'D';
        else grade = 'F';
    }

    void display() {
        System.out.println(name + " | Total: " + total + " | Avg: " + average + " | Grade: " + grade);
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            int[] marks = new int[subjects];
            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter marks for subject " + (j+1) + ": ");
                marks[j] = sc.nextInt();
            }
            sc.nextLine(); // consume newline

            students.add(new Student(name, marks));
        }

        System.out.println("\n----- Results -----");
        for (Student s : students) {
            s.display();
        }
    }
}
