package A_PB.OldExams;

import java.util.Scanner;

public class BakingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int partCount = Integer.parseInt(scanner.nextLine());

        int totalCakesCount = 0;
        int totalCookiesCount = 0;
        int totalWafflesCount = 0;


        for (int i = 1; i <= partCount; i++) {

            int cakesCount = 0;
            int cookiesCount = 0;
            int wafflesCount = 0;
            String input = "";

            boolean bake = true;
            input = scanner.nextLine();
            while (bake) {

                String cakeType = scanner.nextLine();
                if (cakeType.equals("Stop baking!")) {
                    bake = false;
                    break;
                }

                int count = Integer.parseInt(scanner.nextLine());
                switch (cakeType) {
                    case "cookies":
                        cookiesCount+=count;
                        totalCookiesCount+=count;
                        break;
                    case "cakes":
                        cakesCount+=count;
                        totalCakesCount+=count;
                        break;
                    case "waffles":
                        wafflesCount+=count;
                        totalWafflesCount+=count;
                        break;
                }

            }
            System.out.printf("%s baked %d cookies, %d cakes and %d waffles.%n"
                    ,input,cookiesCount,cakesCount,wafflesCount);
        }
        int totalBakery = totalCakesCount+totalCookiesCount+totalWafflesCount;
        double cakesPrice = totalCakesCount * 7.80;
        double cookiesPrice = totalCookiesCount * 1.5;
        double wafflesPrice = totalWafflesCount * 2.30;
        double  totalPrice = cakesPrice+cookiesPrice+wafflesPrice;
        System.out.printf("All bakery sold: %d%nTotal sum for charity: %.2f lv.",totalBakery,totalPrice);

    }
}
