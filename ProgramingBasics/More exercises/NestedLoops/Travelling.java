package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        while (!destination.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double savedMoney = 0;
            while (savedMoney < budget) {
                double currentSavedMoney = Double.parseDouble(scanner.nextLine());
                savedMoney += currentSavedMoney;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}
