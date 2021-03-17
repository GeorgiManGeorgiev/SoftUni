package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class petShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogsCount = Integer.parseInt(scanner.nextLine());
        int otherAnimalsCount = Integer.parseInt(scanner.nextLine());
        double dogFoodCostPerCount = 2.50;
        double otherAnimalsFoodCostPerCount = 4;
        double dogFoodCost = dogsCount * dogFoodCostPerCount;
        double otherAnimalsFoodCost = otherAnimalsCount * otherAnimalsFoodCostPerCount;
        double totalExpenses = otherAnimalsFoodCost + dogFoodCost;
        System.out.printf("%.2f", totalExpenses);
        System.out.print(" lv.");
    }
}
