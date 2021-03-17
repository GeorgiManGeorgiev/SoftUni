package B_FM.List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Add":
                    int numToAdd = Integer.parseInt(commands[1]);
                    numbers.add(numToAdd);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt(commands[1]);
                    int indexToInsert = Integer.parseInt(commands[2]);
                    if (indexToInsert >= 0 && indexToInsert < numbers.size()) {
                        numbers.add(indexToInsert, numToInsert);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "Remove":
                    int indexToRemove = Integer.parseInt(commands[1]);
                    if (indexToRemove >= 0 && indexToRemove < numbers.size()) {
                        numbers.remove(indexToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }

                    break;

                case "Shift":
                    int shiftCount = Integer.parseInt(commands[2]);
                    if (commands[1].equals("left")) {
                        for (int i = 0; i < shiftCount; i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }

                    } else {
                        for (int i = 0; i < shiftCount; i++) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);

                        }
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
