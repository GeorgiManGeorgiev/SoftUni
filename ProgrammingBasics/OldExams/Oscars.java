package A_PB.OldExams;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        double pointsFromJ = 0;
        double totalPoints = 0;
        int judgesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < judgesCount; i++) {
            String jName = scanner.nextLine();
            double jPoints = Double.parseDouble(scanner.nextLine());
            int jNameLength = jName.length();
            double points = (jNameLength * jPoints) / 2;
            pointsFromJ += points;

            totalPoints = pointsFromJ + academyPoints;

            if (totalPoints > 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, (totalPoints));
                break;
            }
        }
        if (totalPoints <= 1250.5) {
            double diff = 1250.5 - totalPoints;
            System.out.printf("Sorry, %s you need %.1f more!", actorName, diff);

        }
    }
}
