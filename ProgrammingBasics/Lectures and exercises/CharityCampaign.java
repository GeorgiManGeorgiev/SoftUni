package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cakePrice = 45;
        double wafflePrice = 5.80;
        double pancakePrice = 3.20;
        int daysCount = Integer.parseInt(scanner.nextLine());
        int bakersCount = Integer.parseInt(scanner.nextLine());
        int cakesCount = Integer.parseInt(scanner.nextLine());
        int wafflesCount = Integer.parseInt(scanner.nextLine());
        int pancakesCount = Integer.parseInt(scanner.nextLine());
        double cakesPrice = cakesCount * cakePrice;
        double wafflesPrice = wafflesCount * wafflePrice;
        double pancakesPrice = pancakesCount * pancakePrice;
        double totalPrice = (cakesPrice + wafflesPrice + pancakesPrice) * bakersCount * daysCount;
        double totalPriceAfterExpenses = totalPrice - (totalPrice / 8);
        System.out.println(String.format("%.2f", totalPriceAfterExpenses));
}
}
