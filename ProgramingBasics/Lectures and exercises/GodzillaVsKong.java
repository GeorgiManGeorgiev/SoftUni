package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double statist = Double.parseDouble(scanner.nextLine());
        double pricePerCostume = Double.parseDouble(scanner.nextLine());
        double decor = budget * 0.1;
        budget *= 0.9;
        double totalCostumePrice = statist * pricePerCostume;
        if (statist > 150) {
            totalCostumePrice *= 0.9;
        }
        budget -= totalCostumePrice;
        if (budget >= 0) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget);
        } else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", Math.abs(budget));
        }
    }

}
