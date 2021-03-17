package C_JavaAdvanced.JavaAdv.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.function.BiPredicate;

import java.util.stream.Collectors;

public class ListOfPredicates {
    public static BiPredicate<Integer, Integer> predicate = (f, s) -> f % s == 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = 1; i <=n ; i++) {
            boolean isValid = true;
            for (int j = 0; j < numbers.size(); j++) {
                if (!predicate.test(i,numbers.get(j))){
                       isValid = false;
                       break;
                   }
            }
            if (isValid){
                System.out.print(i+" ");
            }
        }
    }
}
