package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new HashMap<>();

        String line = "";

        while (!"search".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phoneBook.put(name, number);
        }

        while (!"stop".equals(line)) {
            if (phoneBook.containsKey(line)) {
                System.out.printf("%s -> %s%n", line, phoneBook.get(line));
            } else {
                if (!"search".equals(line)) {
                    System.out.printf("Contact %s does not exist.%n", line);
                }
            }

            line = scanner.nextLine();
        }


    }
}
