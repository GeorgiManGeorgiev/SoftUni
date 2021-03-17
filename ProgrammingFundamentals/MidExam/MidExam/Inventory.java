package B_FM.MidExam.MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());


        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] commands = input.split(" - ");

            switch (commands[0]) {

                case "Collect":
                    String itemToAdd = commands[1];
                    if (!journal.contains(itemToAdd)) {
                        journal.add(itemToAdd);
                    }
                    break;

                case "Drop":
                    String itemToRemove = commands[1];
                    int indexToRemove = journal.indexOf(itemToRemove);
                    if (indexToRemove >= 0) {
                        journal.remove(indexToRemove);
                    }
                    break;

                case "Combine Items":
                    String[] itemsToCombine  = commands[1].split(":");
                    String oldItem = itemsToCombine[0];
                    String newItem = itemsToCombine[1];
                    if (journal.contains(oldItem)) {
                        int indexOfOldItem = journal.indexOf(oldItem);
                        journal.add(indexOfOldItem + 1, newItem);
                    }
                    break;

                case "Renew":
                    String itemToRenew = commands[1];
                    if (journal.contains(itemToRenew)) {
                        int indexToRenew = journal.indexOf(itemToRenew);
                        String toRenew = journal.remove(indexToRenew);
                        journal.add(toRenew);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

            System.out.println(String.join(", ",journal));


    }
}
