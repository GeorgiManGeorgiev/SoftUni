package B_FM.MidExam.April;

import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double priceFor1KGFlour = Double.parseDouble(scanner.nextLine());

        double priceOfEggs = priceFor1KGFlour * 0.75;
        double priceOf1LMilk = priceFor1KGFlour * 1.25;

        double priceOfCozonac = priceOfEggs
                + priceFor1KGFlour
                + (priceOf1LMilk / 4);

        int coloredEggsCount = 0;
        int cozonacsCount = 0;

        while (budget >= priceOfCozonac) {


            cozonacsCount++;
            coloredEggsCount += 3;
            if (cozonacsCount % 3 == 0) {
                int lostColoredEggsCount = cozonacsCount - 2;
                coloredEggsCount -= lostColoredEggsCount;
            }
            budget -= priceOfCozonac;
        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left."
                ,cozonacsCount,coloredEggsCount,budget);
    }
}
