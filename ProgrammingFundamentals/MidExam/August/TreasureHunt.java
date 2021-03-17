package B_FM.MidExam.August;

        import java.util.*;
        import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> chest = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {
            String[] commandArguments = command.split("\\s+");
            String commandName = commandArguments[0];
            switch (commandName) {
                case "Loot":
                    for (int i = 1; i < commandArguments.length; i++) {
                        if (!chest.contains(commandArguments[i])) {
                            chest.add(0, commandArguments[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commandArguments[1]);
                    if (index >= chest.size() || index <= 0) {
                        break;
                    }
                    String element = chest.remove(index);
                    chest.add(element);

                    break;
                case "Steal":
                    int count = Integer.parseInt(commandArguments[1]);
                    if (count >= chest.size()) {
                        System.out.println(String.join(", ", chest));
                        chest.clear();
                        break;
                    }
                    List<String> stolen = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        stolen.add(chest.remove(chest.size() - 1));

                    }
                    Collections.reverse(stolen);
                    System.out.println(String.join(", ", stolen));
                    break;
            }
            command = scanner.nextLine();
        }

        if (chest.size() > 0) {
            double lengthSum = 0;
            for (String s : chest) {
                lengthSum += s.length();
            }

            System.out.printf
                    ("Average treasure gain: %.2f pirate credits.",
                            ((lengthSum * 1.0) / chest.size()));
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
