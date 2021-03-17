package C_JavaAdvanced.JavaAdv.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Function<List<Integer>, Integer> findLeftMostMinElement =
                list -> {
                    int min = Integer.MAX_VALUE;
                    int index=-1;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) <= min) {
                            min = list.get(i);
                            index = i;
                        }
                    }
                return index;
                };

        System.out.println(findLeftMostMinElement.apply(Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList())));


    }
}
