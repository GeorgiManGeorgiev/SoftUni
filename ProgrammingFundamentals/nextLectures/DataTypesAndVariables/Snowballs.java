package B_FM.nextLectures.DataTypesAndVariables;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowBallCount = Integer.parseInt(scanner.nextLine());
        long maxValue = 0;
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;

        while (snowBallCount-- > 0) {
            int snowBallSnow = Integer.parseInt(scanner.nextLine());
            int snowBallTime = Integer.parseInt(scanner.nextLine());
            int snowBallQuality = Integer.parseInt(scanner.nextLine());
            long snowBallValue = (long) Math.pow((snowBallSnow / snowBallTime), snowBallQuality);
            if (snowBallValue >= maxValue) {
                maxValue = snowBallValue;
                bestSnow = snowBallSnow;
                bestTime = snowBallTime;
                bestQuality = snowBallQuality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", bestSnow, bestTime, maxValue, bestQuality);
    }
}
