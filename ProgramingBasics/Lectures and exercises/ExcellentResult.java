package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class ExcellentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        boolean isGradeExcellent = grade >= 5.50;
        if (isGradeExcellent) {
            System.out.println("Excellent!");
        }
    }
}
