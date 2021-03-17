package A_PB.OldExams;

import java.util.Scanner;

public class TripExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double remainder = 0;

        int days = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= days; i++) {

            double balance = 60 + remainder;
            int itemCount = 0;

            String input = scanner.nextLine();

            while (true) {
                if (input.equals("Day over")) {
                    System.out.printf("Money left from today: %.2f." +
                            " You've bought %d products.%n", balance, itemCount);
                    remainder = balance;
                    break;
                }
                double itemPrice = Double.parseDouble(input);
                if (itemPrice <= balance) {
                    itemCount++;
                    balance -= itemPrice;
                }
                if (balance == 0) {
                    System.out.printf("Daily limit exceeded! You've bought %d products.%n", itemCount);
                    break;

                }
                input = scanner.nextLine();
            }
        }
    }
}


