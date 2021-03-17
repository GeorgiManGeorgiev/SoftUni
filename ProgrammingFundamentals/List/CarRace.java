package B_FM.List;

import java.util.Arrays;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] laps = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int middleIndex = laps.length / 2 ;
        double leftSum = 0;
        double rightSum = 0;
        for (int i = 0; i < middleIndex; i++) {
            if (laps[i] == 0) {
                leftSum *= 0.8;
            } else {
                leftSum += laps[i];
            }
        }
        for (int i = laps.length - 1; i > middleIndex; i--) {
            if (laps[i] == 0) {
                rightSum *= 0.8;
            } else {
                rightSum += laps[i];
            }
        }

        if (leftSum < rightSum) {
            System.out.printf("The winner is left with total time: %.1f",leftSum);
        }else{
            System.out.printf("The winner is right with total time: %.1f",rightSum);
        }


    }
}
