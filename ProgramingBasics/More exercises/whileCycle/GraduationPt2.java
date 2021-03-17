package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int gradeCount = 1;
        double gradeSum = 0.0;
        while (gradeCount <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade >= 4.00) {
                gradeSum = gradeSum + grade;
                gradeCount++;
            }else {
                System.out.printf("%s has been excluded at %d grade",name,gradeCount);
                return;
            }
        }
        System.out.printf("%s graduated. Average grade: %.2f", name, (gradeSum / 12));
    }
}
