package A_PB.pastLectures.forCycle;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double priceOfWasher = Double.parseDouble(scanner.nextLine());
        int priceOfToy = Integer.parseInt(scanner.nextLine());
        int moneyForBirthday = 0;
        int sumMoney = 0;
        int toyCount = 0;
        for (int birthdays = 1; birthdays <= age; birthdays++) {
            if (birthdays % 2 == 1) {
                //toy
                toyCount++;
            } else {
                moneyForBirthday += 10;
                sumMoney += moneyForBirthday - 1;
            }

        }
        int totalSum = sumMoney + (toyCount * priceOfToy);
        if (totalSum >= priceOfWasher) {
            double left = totalSum - priceOfWasher;
            System.out.printf("Yes! %.2f", left);
        } else {
            double needMoney = priceOfWasher - totalSum;
            System.out.printf("No! %.2f", needMoney);
        }
    }
}
