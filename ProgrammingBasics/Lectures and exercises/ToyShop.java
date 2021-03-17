package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tripPrise = Double.parseDouble(scanner.nextLine());
        int puzzleCount = Integer.parseInt(scanner.nextLine());
        int dollCount = Integer.parseInt(scanner.nextLine());
        int bearsCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int truckCount = Integer.parseInt(scanner.nextLine());
        double puzzlesProfit = puzzleCount * 2.60;
        double dollsProfit = dollCount * 3;
        double bearsProfit = bearsCount * 4.10;
        double minionsProfit = minionsCount * 8.20;
        double trucksProfit = truckCount * 2;
        double profit = puzzlesProfit + dollsProfit + bearsProfit + minionsProfit + trucksProfit;
        int toysCount = puzzleCount + dollCount + bearsCount + minionsCount + truckCount;
        if (toysCount >= 50) {
            profit = profit * 0.75;
        }
        double totalProfit = profit * 0.90;
        double moneyLeft = totalProfit - tripPrise;
        if (totalProfit >= tripPrise) {
            System.out.printf("Yes! %.2f lv left.", moneyLeft);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrise - totalProfit);
        }

    }
}
