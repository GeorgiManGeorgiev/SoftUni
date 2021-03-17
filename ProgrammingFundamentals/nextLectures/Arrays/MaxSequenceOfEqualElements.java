package B_FM.nextLectures.Arrays;

import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int counter = 0;
        int currentCounter = 0;
        String currentSequence = "";
        String sequence = "";

        for (int i = 0; i < numbers.length; i++) {

            currentCounter = 0;
            currentSequence = "";

            for (int j = i + 1; j < numbers.length ; j++) {
                if (numbers[i] == numbers[j]) {
                    currentCounter++;
                    currentSequence += numbers[i] + " ";
                } else {
                    break;
                }
            }
            if (currentCounter > counter) {
                counter = currentCounter;
                sequence = currentSequence + numbers[i];

            }
        }
        if (sequence.equals("")) {
            System.out.println(numbers[0]);
        }

        System.out.println(sequence);
    }
}
