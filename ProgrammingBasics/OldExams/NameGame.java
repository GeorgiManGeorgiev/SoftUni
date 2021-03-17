package A_PB.OldExams;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isOn = true;
        String winnerName = "";
        int winPoints = 0;

        while (isOn) {
            int points = 0;

            String name = scanner.nextLine();
            if (name.equals("Stop")) {
                break;
            }
            int nameLength = name.length();

            for (int i = 0; i <= nameLength - 1; i++) {
                int currentNum = Integer.parseInt(scanner.nextLine());
                char currentChar = name.charAt(i);
                int currentCharAsInt = (int) currentChar;

                if (currentCharAsInt == currentNum) {
                    points += 10;
                } else {
                    points += 2;
                }
            }
            if (winPoints <= points) {
                winPoints = points;
                winnerName = name;

            }
        }
        System.out.printf("The winner is %s with %d points!", winnerName, winPoints);
    }
}
