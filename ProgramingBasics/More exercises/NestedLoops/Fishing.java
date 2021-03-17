package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class Fishing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quota = Integer.parseInt(scan.nextLine());
        String fishName = "";
        int fishCount = 0;
        Double moneyToTake = 0.0;
        Double moneyToGive = 0.0;

        while (!"Stop".equals(fishName)) {
            if (quota == fishCount) {
                System.out.printf("Lyubo fulfilled the quota!%n");
                break;
            }
            fishName = scan.nextLine();
            if (fishName.equals("Stop")) {
                break;
            }
            double fishWeight = Double.parseDouble(scan.nextLine());
            int fishValue = 0;
            for (int i = 0; i < fishName.length(); i++) {
                char fishNameCurrentChar = fishName.charAt(i);
                int valueOfCurrentChar = (int) fishNameCurrentChar;
                fishValue += valueOfCurrentChar;
            }
            double fishTotalValue = fishValue / fishWeight;
            fishCount++;
            if (fishCount % 3 == 0) {
                moneyToTake += fishTotalValue;
            } else {
                moneyToGive += fishTotalValue;
            }

        }
        if (moneyToGive < moneyToTake) {
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.", fishCount, (moneyToTake - moneyToGive));
        } else {
            System.out.printf("Lyubo lost %.2f leva today.", moneyToGive - moneyToTake);
        }
    }
}
