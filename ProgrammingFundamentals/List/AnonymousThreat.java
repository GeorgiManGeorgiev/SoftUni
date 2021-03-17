package B_FM.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("3:1")) {

            String[] actions = command.split("\\s+");

            switch (actions[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(actions[1]);
                    int endIndex = Integer.parseInt(actions[2]);
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (startIndex > input.size() - 1) {
                        startIndex = 0;
                    }
                    if (endIndex > input.size() - 1) {
                        endIndex = input.size() - 1;
                    }
                    if (endIndex < 0) {
                        endIndex = input.size() - 1;
                    }

                    String elementToAdd = "";
                    if (startIndex != endIndex) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            elementToAdd += input.get(i);
                        }
                        for (int i = startIndex; i <= endIndex; i++) {
                            input.remove(startIndex);
                        }

                        input.add(startIndex, elementToAdd);
                    }
                    break;

                case "divide":
                    int index = Integer.parseInt(actions[1]);
                    int partitions = Integer.parseInt(actions[2]);

                    if (index >= 0 && index < input.size() && partitions >= 0 && partitions <= 100) {
                        String element = input.get(index);
                        List<String> newList = new ArrayList<>();

                        if (element.length() % partitions == 0) {
                            int portionLength = element.length() / partitions;
                            int count = 0;
                            for (int i = 0; i < partitions; i++) {
                                String concat = "";
                                for (int j = 0; j < portionLength; j++) {
                                    char symbol = element.charAt(count);
                                    concat += symbol;
                                    count++;
                                }
                                newList.add(concat);
                            }
                        } else {
                            int portionLength = element.length() / partitions;
                            int count = 0;
                            for (int i = 0; i < partitions; i++) {
                                String concat = "";

                                if (i == partitions - 1) {
                                    for (int j = count; j <element.length() ; j++) {
                                        char symbol = element.charAt(count);
                                        concat+=symbol;
                                        count++;
                                    }
                                }else {
                                    for (int j = 0; j <portionLength ; j++) {
                                        char symbol = element.charAt(count);
                                        concat+=symbol;
                                        count++;
                                    }
                                }
                                newList.add(concat);
                            }
                        }
                        input.remove(index);
                        input.addAll(index,newList);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(input.toString().replaceAll("[\\[\\],]", ""));
    }
}
