package A_PB.OldExams;

import java.util.Scanner;

public class FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieWin = "";
        int movieWinPoints = 0;

        boolean isOn = true;
        int limit = 7;
        while (isOn) {
            String movieOrStop = scanner.nextLine();
            limit--;
            if (movieOrStop.equals("STOP") || limit == 0) {
                break;
            }
            int moviePoints = 0;
            int movieLength = movieOrStop.length();
            for (int i = 0; i <= movieLength - 1; i++) {
                char currentChar = movieOrStop.charAt(i);
                int currentCharAsInt = (int) currentChar;

                        moviePoints += currentCharAsInt;
                if (currentChar >= 'a' && currentChar <= 'z') {
                    moviePoints = moviePoints-(2*movieLength);
                }if (currentChar >= 'A' && currentChar <= 'Z'){
                    moviePoints = moviePoints-movieLength;
                }
            }
            if (moviePoints > movieWinPoints) {
                movieWinPoints = moviePoints;
                movieWin = movieOrStop;
            }
        }

        if (limit == 0) {
            System.out.printf("The limit is reached.%n");
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", movieWin, movieWinPoints);
    }
}

