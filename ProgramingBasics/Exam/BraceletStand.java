package A_PB.Exam;

import java.util.Scanner;

public class BraceletStand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dailyMoney = Double.parseDouble(scanner.nextLine());
        double profitPerDay = Double.parseDouble(scanner.nextLine());
        double expensesOverAll = Double.parseDouble(scanner.nextLine());
        double priceOfGift = Double.parseDouble(scanner.nextLine());

        int days = 5;
        double profit = (days*profitPerDay)+(days*dailyMoney);
        double result = profit-expensesOverAll;

        if (result>=priceOfGift){

            System.out.printf("Profit: %.2f BGN, the gift has been purchased.",result);
        }else {
            double diff = Math.abs(result-priceOfGift);
            System.out.printf("Insufficient money: %.2f BGN.",diff);
        }



    }
}
