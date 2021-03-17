package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.lang.reflect.Array;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<Double>> students = new TreeMap<>();
        int studentsCount = Integer.parseInt(scanner.nextLine());

        while (studentsCount-- > 0) {
            String[] line = scanner.nextLine().split(" ");
            String studentName = line[0];
            double studentGrade = Double.parseDouble(line[1]);
            ArrayList<Double> grades = new ArrayList<>();
            grades.add(studentGrade);
            if (students.containsKey(studentName)) {
                ArrayList<Double> current = students.get(studentName);
                current.add(grades.get(0));
                students.put(studentName, current);
            } else {
                students.put(studentName, grades);

            }
        }

        for (Map.Entry<String, ArrayList<Double>> entry : students.entrySet()) {

            double sum = 0;
            String name = entry.getKey();
            ArrayList<Double> grades = entry.getValue();
            System.out.print(name + " -> ");
            for (Double grade : grades) {
                sum += grade;
                System.out.printf("%.2f ",grade);
            }
            double average = sum / grades.size();
            System.out.printf("(avg: %.2f)",average);
            System.out.println();

        }
    }
}
