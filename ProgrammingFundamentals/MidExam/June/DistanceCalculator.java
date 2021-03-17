package B_FM.MidExam.June;

import java.util.Scanner;

public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stepsMade = Integer.parseInt(scanner.nextLine());
        double oneStepInCM = Double.parseDouble(scanner.nextLine());
        int distanceInMeters = Integer.parseInt(scanner.nextLine());
        double distanceInCM = distanceInMeters * 100.0;
        int shortStepsMade = stepsMade / 5;
        int normalStepsMade = stepsMade - shortStepsMade;

        double distanceMade = (normalStepsMade * oneStepInCM)
                + (shortStepsMade * (oneStepInCM * 0.7));

        double percentTravelled = distanceMade/distanceInCM * 100;

        System.out.printf("You travelled %.2f%% of the distance!",percentTravelled);

    }
}
