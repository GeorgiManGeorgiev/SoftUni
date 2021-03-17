package B_FM.Methods;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Math.abs(scanner.nextInt());
        System.out.println(getMultipleOfEvensAndOdds(a));

    }

    private static int getMultipleOfEvensAndOdds(int a) {
        int evenSum = getSumOfEvenDigits(a);
        int oddSum = getSumOfOddDigits(a);
        return evenSum * oddSum;
    }

    private static int getSumOfEvenDigits(int a) {
        int evenSum = 0;
        while (a != 0) {
            int newNum = a % 10;
            if (newNum % 2 == 0) {
                evenSum += newNum;
            }
            a /= 10;
        }
        return evenSum;
    }

    private static int getSumOfOddDigits(int a) {
        int oddSum = 0;
        while (a != 0) {
            int newNum = a % 10;
            if (newNum % 2 == 1) {
                oddSum += newNum;
            }
            a /= 10;
        }
        return oddSum;
    }
}
