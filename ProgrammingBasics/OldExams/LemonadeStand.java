package A_PB.OldExams;

import java.util.Scanner;

public class LemonadeStand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lemonKg = Double.parseDouble(scanner.nextLine());
        double sugarKg = Double.parseDouble(scanner.nextLine());
        double waterLtr = Double.parseDouble(scanner.nextLine());

        double lemonJuiceMLtr = lemonKg * 980;
        double mixMLtr = lemonJuiceMLtr + (sugarKg *0.3);
        double totalMixMLtr = mixMLtr + (waterLtr*1000);
        double cupsCount = Math.floor(totalMixMLtr / 150);
        double profit= cupsCount * 1.20;


        System.out.printf("All cups sold: %.0f%nMoney earned: %.2f",cupsCount,profit);
    }
}
