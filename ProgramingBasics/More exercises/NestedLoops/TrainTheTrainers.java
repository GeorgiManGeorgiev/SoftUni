package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int juryCnt = Integer.parseInt(scan.nextLine());
        String presentationName = scan.nextLine();
        double totalGradesSum = 0.0;
        int totalGradesCounter = 0;
        while (!"Finish".equals(presentationName)) {
            double currentGrades = 0.0;
            for (int i = 0; i < juryCnt; i++) {
                totalGradesCounter++;
                currentGrades += Double.parseDouble(scan.nextLine());
            }
            double currentAverageGrade = currentGrades / juryCnt;
            System.out.printf("%s - %.2f.%n", presentationName, currentAverageGrade);
            totalGradesSum += currentGrades;

            presentationName = scan.nextLine();
        }
        double averageGrades = totalGradesSum / totalGradesCounter;
        System.out.printf("student's final assessment is %.2f.", averageGrades);
    }
}
