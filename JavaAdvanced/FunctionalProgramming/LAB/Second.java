package C_JavaAdvanced.JavaAdv.FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ToIntFunction<String> parseInt = Integer::parseInt;

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(parseInt)
                .toArray();

        Function<int[], int[]> printCount = arr -> {
            System.out.println("Count = " + arr.length);
            return arr;
        };

        Function<int[], String> formatArrSum = arr ->
                "Sum = " + Arrays.stream(arr).sum();


        System.out.println(printCount.andThen(formatArrSum).apply(numbers));


    }
}
