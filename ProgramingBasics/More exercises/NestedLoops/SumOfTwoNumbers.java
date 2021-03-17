package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingNumber = Integer.parseInt(scanner.nextLine());
        int finalNumber = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int combinations = 0;
        boolean flag = false;
        boolean isEqual = false;
        for (int i = startingNumber; i <= finalNumber; i++) {
            for (int j = startingNumber; j <= finalNumber; j++) {
                combinations++;
                if (i + j == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", combinations, i, j, magicNumber);
                    flag = true;
                    isEqual = true;
                    return;
                }
                if (flag) {
                    break;
                }
            }
        }
        if (!isEqual) {
            System.out.printf("%d combinations - neither equals %d", combinations, magicNumber);
        }
    }
}
