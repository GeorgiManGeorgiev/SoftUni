package C_JavaAdvanced.JavaAdv.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;


public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], Integer> minFunc = arr -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
            return min;
        };


        System.out.println(minFunc.apply(Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray()));


    }
}
