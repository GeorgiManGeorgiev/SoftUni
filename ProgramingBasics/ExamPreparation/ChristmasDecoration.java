package A_PB.ExamPreparation;

import java.util.Scanner;

public class ChristmasDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            int sum = 0;
            int inputLength = input.length();
            for (int i = 0; i <= inputLength - 1; i++) {
                char currentChar = input.charAt(i);
                int currentCharToInt = (int) currentChar;
                sum += currentCharToInt;
            }
            if (budget >= sum) {
                budget -= sum;
                System.out.printf("Item successfully purchased!%n");
            } else {
                System.out.printf("Not enough money!");
                return;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Money left: %d", budget);
    }
}
