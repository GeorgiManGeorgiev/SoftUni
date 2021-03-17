package A_PB.Exam;

import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coffeeCount = Integer.parseInt(scanner.nextLine());
        int espressoGr = 50;
        int cappuccinoGr = 30;
        int latteGr = 20;
        double profit = 0;
        String input = "";

        while (true) {
            input = scanner.nextLine();
            if (input.equals("closed")) {
                if (coffeeCount > 0) {
                    System.out.printf("Coffee left: %dg%n", coffeeCount);
                    break;
                }
                break;
            }
            if (input.equals("espresso")) {
                if (coffeeCount >= espressoGr) {
                    profit += 3.00;
                    coffeeCount -= espressoGr;
                } else {
                    System.out.printf("Not enough coffee!%n");

                }

            }
            if (input.equals("cappuccino")) {
                if (coffeeCount >= cappuccinoGr) {
                    profit += 3.50;
                    coffeeCount -= cappuccinoGr;
                } else {
                    System.out.printf("Not enough coffee!%n");

                }

            }
            if (input.equals("latte")) {
                if (coffeeCount >= latteGr) {
                    profit += 3.50;
                    coffeeCount -= latteGr;
                } else {
                    System.out.printf("Not enough coffee!%n");

                }

            }

            if (coffeeCount == 0) {
                System.out.printf("No more coffee left!%n");
                break;
            }
        }
        System.out.printf("Profit: %.2f lv.", profit);

    }
}
