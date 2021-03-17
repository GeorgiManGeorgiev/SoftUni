package A_PB.OldExams;

import java.util.Scanner;

public class Savings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double income = Double.parseDouble(scanner.nextLine());
        int mountsCount = Integer.parseInt(scanner.nextLine());
        double expenses = Double.parseDouble(scanner.nextLine());

        double moneyAfterExpAndSavings = income - ((income * 0.3) + expenses);
        double moneySaved = moneyAfterExpAndSavings * mountsCount;
        double percentSavedPerMount = (moneyAfterExpAndSavings / income) * 100;

        System.out.printf("She can save %.2f%%%n%.2f",percentSavedPerMount,(moneySaved));

    }
}
