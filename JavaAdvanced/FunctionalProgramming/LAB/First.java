package C_JavaAdvanced.JavaAdv.FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] evens = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        System.out.println(Arrays.stream(evens)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));

        Arrays.sort(evens);

        System.out.println(Arrays.stream(evens)
                .sorted()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ")));


    }
}
