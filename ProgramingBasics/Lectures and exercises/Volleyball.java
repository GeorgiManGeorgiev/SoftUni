package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        double p = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        int weekendsInYearForV = 48;
        double weekendsInSofia = (weekendsInYearForV - h) * 3/4;
        double weekendsInHomeTown = h;
        double gamesInHollyDays = p * 2/3;
        double totalGames= weekendsInSofia + weekendsInHomeTown + gamesInHollyDays;
        if (year.equals("leap")){
        totalGames += totalGames * 0.15;
        }
        totalGames = Math.floor(totalGames);

        System.out.printf("%.0f",totalGames);
    }
}
