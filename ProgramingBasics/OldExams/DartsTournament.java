package A_PB.OldExams;

import java.util.Scanner;

public class DartsTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startPoints = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        int currentPoints = 0;

        while (startPoints > currentPoints) {
            String sector = scanner.nextLine();
            counter++;
            if (sector.equals("bullseye")) {
                System.out.printf("Congratulations! You won the game with a bullseye in %d moves!", counter);
                return;
            }
            int points = Integer.parseInt(scanner.nextLine());
            if (sector.equals("double ring")) {
                points = points * 2;

            }
            if (sector.equals("triple ring")) {
                points = points * 3;

            }

            currentPoints += points;
            if (startPoints == currentPoints) {
                System.out.printf("Congratulations! You won the game in %d moves!", counter);
            }
            if (currentPoints > startPoints) {
                int diff = currentPoints - startPoints;
                System.out.printf("Sorry, you lost. Score difference: %d.", diff);
            }
        }
    }
}
