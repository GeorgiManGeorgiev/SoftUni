package C_JavaAdvanced.JavaAdv.FunctionalProgramming;

import java.util.Arrays;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Predicate<String> predicate = str->str.length()<=number;
        System.out.println(Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(predicate)
                .collect(Collectors.joining(System.lineSeparator())));


    }
}
