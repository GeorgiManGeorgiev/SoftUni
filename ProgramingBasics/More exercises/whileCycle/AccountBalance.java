package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int paymentsCount = Integer.parseInt(scanner.nextLine());
        double totalAmount = 0.0;
        double amount;
        int c = 1;
        while (c <= paymentsCount) {
            amount = Double.parseDouble(scanner.nextLine());
            if (amount < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", amount);
            totalAmount = totalAmount + amount;
            c++;
        }
        System.out.printf("Total: %.2f", totalAmount);
    }
}


