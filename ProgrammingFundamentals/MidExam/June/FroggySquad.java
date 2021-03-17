package B_FM.MidExam.June;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FroggySquad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> frogs = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        while (true) {
            String[] commands = scanner.nextLine().split(" ");
            switch (commands[0]) {
                case "Join":
                    String frogName = commands[1];
                    frogs.add(frogName);
                    break;
                case "Jump":
                    String name = commands[1];
                    int index = Integer.parseInt(commands[2]);
                    if (index >= 0 && index < frogs.size()) {
                        frogs.add(index, name);
                    }
                    break;

                case "Dive":
                    int indexToRemove = Integer.parseInt(commands[1]);
                    if (indexToRemove >= 0 && indexToRemove < frogs.size()) {
                        frogs.remove(indexToRemove);
                    }
                    break;
                case "ActivationKeys":
                    int countFirst = Integer.parseInt(commands[1]);
                    if (!frogs.isEmpty()) {
                        for (int i = 0; i < countFirst && i < frogs.size(); i++) {
                            System.out.print(frogs.get(i) + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "Last":
                    int countLast = Integer.parseInt(commands[1]);
                    int indexToStart = frogs.size() - countLast;
                    if (indexToStart<0){
                        indexToStart=0;
                    }
                    if (!frogs.isEmpty()) {
                        for (int i = indexToStart; i < frogs.size() ; i++) {
                            System.out.print(frogs.get(i) + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "Print":
                    String normalOrReversed = commands[1];
                    System.out.print("Frogs: ");
                    if (normalOrReversed.equals("Reversed")) {
                        Collections.reverse(frogs);
                    }
                    for (String frog:
                         frogs) {
                        System.out.print(frog + " ");
                    }
                    return;
            }
        }
    }
}

