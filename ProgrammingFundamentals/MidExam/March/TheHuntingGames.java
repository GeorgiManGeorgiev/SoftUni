package B_FM.MidExam.March;

import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int adventureDays = scanner.nextInt();
        int playersCount = scanner.nextInt();
        double groupEnergy = scanner.nextDouble();
        double totalWater = scanner.nextDouble() * adventureDays * playersCount;
        double totalFood = scanner.nextDouble() * adventureDays * playersCount;

        boolean ready = true;

        for (int day = 1; day <= adventureDays; day++) {
            double energyLoss = scanner.nextDouble();

            groupEnergy -= energyLoss;

            if (groupEnergy <= 0) {
                ready = false;
                break;
            }

            if (day % 2 == 0) {
                groupEnergy += groupEnergy * 0.05;
                totalWater -= totalWater * 0.3;

            }
            if (day % 3 == 0) {
                groupEnergy += groupEnergy * 0.1;
                totalFood -= totalFood / (double) playersCount;
            }


        }


        if (ready) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!%n", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.%n", totalFood, totalWater);
        }
    }
}
