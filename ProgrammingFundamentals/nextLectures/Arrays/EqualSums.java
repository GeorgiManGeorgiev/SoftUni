package B_FM.nextLectures.Arrays;

import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        String output = "no";
        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int l = 0; l < i; l++) {
                leftSum += numbers[l];
            }
            for (int r = i + 1; r < numbers.length; r++) {
                rightSum += numbers[r];
            }
            if (leftSum == rightSum) {
                output = i + "";
                break;
            }
        }

        System.out.println(output);
    }
}
