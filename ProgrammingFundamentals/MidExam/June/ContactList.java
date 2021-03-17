package B_FM.MidExam.June;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> contacts = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());


        while (true) {
            String[] commands = scanner.nextLine().split(" ");
            switch (commands[0]) {
                case "Add":
                    String contToAdd = commands[1];
                    int index = Integer.parseInt(commands[2]);
                    if (contacts.contains(contToAdd)) {
                        if (index >= 0 && index <= contacts.size()) {
                            contacts.add(index, contToAdd);
                        }
                    } else {
                        contacts.add(contToAdd);
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commands[1]);
                    if (indexToRemove >= 0 && indexToRemove < contacts.size()) {
                        contacts.remove(indexToRemove);
                    }
                    break;
                case "Export":
                    int indexToStart = Integer.parseInt(commands[1]);
                    int count = Integer.parseInt(commands[2]);
                    if (!contacts.isEmpty()){
                    if (indexToStart >= 0 && indexToStart < contacts.size()) {
                        for (int i = indexToStart; count!=0 && i < contacts.size(); i++) {
                            System.out.print(contacts.get(i) + " ");
                            count--;
                        }

                    }
                    }
                    System.out.println();
                    break;
                case "Print":
                    System.out.print("Contacts: ");
                    if (commands[1].equals("Reversed")) {
                        Collections.reverse(contacts);
                    }
                    for (String contact : contacts) {
                        System.out.print(contact + " ");
                    }
                    return;
            }
        }
    }
}
