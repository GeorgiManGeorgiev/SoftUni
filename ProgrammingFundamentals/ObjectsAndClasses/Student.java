package B_FM.ObjectsAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private double grade;

    public Student(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentsCount ; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String fName = input[0];
            String lName = input[1];
            double grade = Double.parseDouble(input[2]);
            Student student = new Student(fName,lName,grade);
            students.add(student);
        }
        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
