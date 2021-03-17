package B_FM.nextLectures.Arrays;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int begin = 0; begin < numbers.length; begin++) {

            int number = numbers[begin];
            boolean isTopNumber = true;

            for (int i = begin + 1; i < numbers.length; i++) {
                if (number <= numbers[i]) {
                    isTopNumber = false;
                    break;
                }
            }

            if (isTopNumber) {
                System.out.print(number + " ");
            }
        }
    }
}
