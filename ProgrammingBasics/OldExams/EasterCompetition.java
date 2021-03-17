package A_PB.OldExams;

import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cake = Integer.parseInt(scanner.nextLine());

        String winName = "";
        int winScore = 0;

        for (int i = 1; i <= cake; i++) {
            String name = scanner.nextLine();
            String input = "";
            int currentScore = 0;

            while (true) {
                input = scanner.nextLine();
                if ("Stop".equals(input)) {
                    System.out.printf("%s has %d points.%n", name, currentScore);
                    break;
                }
                int score = Integer.parseInt(input);
                currentScore += score;


            }
            if (currentScore > winScore) {
                winScore = currentScore;
                winName = name;
                System.out.printf("%s is the new number 1!%n", winName);
            }
        }
        System.out.printf("%s won competition with %d points!", winName, winScore);
    }
}
