package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPoorGrades = Integer.parseInt(scanner.nextLine());
        String taskName = scanner.nextLine();

        int countOfGrades = 0;
        int countOfProblems = 0;
        double sumOfAllGrades = 0;
        String lastProblem = "";
        int countOfPoorGrades1 = countOfPoorGrades;

        while (!taskName.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());
            sumOfAllGrades += grade;
            countOfProblems++;
            countOfGrades++;
            lastProblem = taskName;
            if (grade <= 4) {
                countOfPoorGrades--;
            }
            if (countOfPoorGrades == 0){
                System.out.printf("You need a break, %d poor grades.",countOfPoorGrades1);
                break;
            }
            taskName = scanner.nextLine();
        }
        if (countOfPoorGrades!=0) {
            double average = sumOfAllGrades / countOfGrades;
            System.out.printf("Average score: %.2f%n", average);
            System.out.printf("Number of problems: %d%n", countOfProblems);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}
