package A_PB.OldExams;

import java.util.Scanner;

public class CruiseGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        int gamesPlayed = Integer.parseInt(scanner.nextLine());
        double vPoints = 0;
        double tPoints = 0;
        double bPoints = 0;
        int vGames = 0;
        int tGames = 0;
        int bGames = 0;


        for (int i = 1; i <= gamesPlayed; i++) {
            String gameName = scanner.nextLine();
            double points = 0;
            points = Double.parseDouble(scanner.nextLine());

            if (gameName.equals("volleyball")) {
                points = points + (points * 0.07);
                vPoints += points;
                vGames++;

            }
            if (gameName.equals("tennis")) {
                points = points + (points * 0.05);
                tPoints += points;
                tGames++;

            }
            if (gameName.equals("badminton")) {
                points = points + (points * 0.02);
                bPoints += points;
                bGames++;
            }
        }
        double avrVPoints = Math.floor(vPoints / vGames);
        double avrTPoints = Math.floor(tPoints / tGames);
        double avrBPoints = Math.floor(bPoints / bGames);

        double totalScore = Math.floor(vPoints+ tPoints + bPoints);

        if (avrVPoints >= 75 && avrTPoints >= 75 && avrBPoints >= 75) {
            System.out.printf("Congratulations, %s! You won the cruise games with %.0f points.", playerName, totalScore);
        } else {
            System.out.printf("Sorry, %s, you lost. Your points are only %.0f.", playerName, totalScore);
        }

    }
}
