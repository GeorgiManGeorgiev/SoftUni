package B_FM.List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {

            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {

                case "Contains":
                    int numToCheck = Integer.parseInt(tokens[1]);
                    if (numbers.contains(numToCheck)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        for (int curr :
                                numbers) {
                            if (curr % 2 == 0) {
                                System.out.print(curr + " ");
                            }
                        }
                    }
                    if (tokens[1].equals("odd")) {
                        for (int curr :
                                numbers) {
                            if (curr % 2 == 1) {
                                System.out.print(curr + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    if (tokens[1].equals("sum")) {
                        for (int curr :
                                numbers) {
                            sum += curr;
                        }
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    int numToFilter = Integer.parseInt(tokens[2]);
                    switch (tokens[1]) {
                        case "<":
                            for (int curr :
                                    numbers
                            ) {
                                if (curr < numToFilter) {
                                    System.out.print(curr + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int curr :
                                    numbers
                            ) {
                                if (curr > numToFilter) {
                                    System.out.print(curr + " ");
                                }
                            }
                            System.out.println();
                            break;


                        case ">=":
                            for (int curr :
                                    numbers
                            ) {
                                if (curr >= numToFilter) {
                                    System.out.print(curr + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int curr :
                                    numbers
                            ) {
                                if (curr <= numToFilter) {
                                    System.out.print(curr + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
            }
            input = scanner.nextLine();
        }
    }
}
