package B_FM.nextLectures.DataTypesAndVariables;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());

        int days = 0;
        long totalAmount = 0;
        if (startingYield>=100) {
            while (startingYield >= 100) {
                totalAmount += startingYield;
                startingYield -= 10;
                totalAmount -= 26;
                days++;
            }
            totalAmount -= 26;
            System.out.printf("%d%n%d", days, totalAmount);
        }else {
            System.out.printf("%d%n%d", days, totalAmount);
        }
    }
}
