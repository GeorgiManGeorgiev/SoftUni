package A_PB.Exam;

import java.util.Scanner;

public class BirdFarm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int priceOfEgg = Integer.parseInt(scanner.nextLine());
        int hensCount = Integer.parseInt(scanner.nextLine());
        int hensCount2 = Integer.parseInt(scanner.nextLine());
        int hensCount3 = Integer.parseInt(scanner.nextLine());

        double eggCount1mount = (hensCount * 20) * 0.96;
        double eggCount2mount = ((hensCount + hensCount2) * 20) * 0.96;
        double eggCount3mount = ((hensCount + hensCount2 + hensCount3) * 20) * 0.96;
        double eggCount = Math.floor(eggCount1mount + eggCount2mount + eggCount3mount);
        double result = (eggCount * priceOfEgg)/100;
        double resultInLv = Math.floor(result);

        System.out.printf("Profit: %.0f Lv.", resultInLv);
    }
}
