package A_PB.Exam;

import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cakeType = scanner.nextLine();
        int cakeCount = Integer.parseInt(scanner.nextLine());
        int dayOfDec = Integer.parseInt(scanner.nextLine());

        double priceOfCake = 0;
        double priceOfSouffle = 0;
        double priceOfBaklava = 0;

        double totalPriceOfCakes = 0;


        if (dayOfDec <= 15) {
            switch (cakeType) {
                case "Cake":
                    priceOfCake = 24;
                    break;
                case "Souffle":
                    priceOfSouffle = 6.66;
                    break;
                case "Baklava":
                    priceOfBaklava = 12.60;
                    break;
            }
        }
        if (dayOfDec > 15) {
            switch (cakeType) {
                case "Cake":
                    priceOfCake = 28.7;
                    break;
                case "Souffle":
                    priceOfSouffle = 9.8;
                    break;
                case "Baklava":
                    priceOfBaklava = 16.98;
                    break;
            }
        }
        totalPriceOfCakes = (priceOfCake + priceOfSouffle + priceOfBaklava) * cakeCount;

        if (dayOfDec <= 22) {
            if (totalPriceOfCakes >= 100 && totalPriceOfCakes <= 200) {
                totalPriceOfCakes *= 0.85;

            }
            if (totalPriceOfCakes > 200) {
                totalPriceOfCakes *= 0.75;
            }
            if (dayOfDec <= 15) {
                totalPriceOfCakes *= 0.9;
            }

        }
        System.out.printf("%.2f", totalPriceOfCakes);
    }
}
