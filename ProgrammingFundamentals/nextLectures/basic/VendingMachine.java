package B_FM.nextLectures.basic;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        double nutsPrice = 2.0;
        double waterPrice = 0.7;
        double crispsPrice = 1.5;
        double sodaPrice = 0.8;
        double cokePrice = 1.0;

        double coinsSum = 0;
        double purchaseCost = 0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);

            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                coinsSum += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }
        while (!input.equals("End")) {

            if (input.equals("Start")) {
                input = scanner.nextLine();
            }

            switch (input) {
                case "Nuts":
                    if ((coinsSum - purchaseCost) >= nutsPrice) {
                        purchaseCost += nutsPrice;
                        System.out.println("Purchased Nuts");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if ((coinsSum - purchaseCost) >= waterPrice) {
                        purchaseCost += waterPrice;
                        System.out.println("Purchased Water");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if ((coinsSum - purchaseCost) >= crispsPrice) {
                        purchaseCost += crispsPrice;
                        System.out.println("Purchased Crisps");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if ((coinsSum - purchaseCost) >= sodaPrice) {
                        purchaseCost += sodaPrice;
                        System.out.println("Purchased Soda");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if ((coinsSum - purchaseCost) >= cokePrice) {
                        purchaseCost += cokePrice;
                        System.out.println("Purchased Coke");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.printf("Invalid product%n");
                    break;
            }
            input = scanner.nextLine();

        }
        System.out.printf("Change: %.2f", coinsSum - purchaseCost);
    }
}
