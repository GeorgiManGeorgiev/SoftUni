package B_FM.List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String line;
        while (!"end".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Delete":
                    String element = tokens[1];
                    while (elements.contains(element))
                        elements.remove(element);
                    break;
                case "Insert":
                    element = tokens[1];
                    int position = Integer.parseInt(tokens[2]);
                    if (0 <= position && position < elements.size()) {
                        elements.add(position, element);
                    }
                    break;
            }
        }
        System.out.println(elements.toString().replaceAll("[\\[\\],]", ""));

    }
}
