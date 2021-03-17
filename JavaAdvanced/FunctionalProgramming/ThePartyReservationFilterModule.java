package C_JavaAdvanced.JavaAdv.FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        Map<String, Predicate<String>> predicates = new HashMap<>();

        while (!input.equals("Print")) {

            String[] tokens = input.split(";");


            if (tokens[0].contains("Add")) {
                predicates.put(tokens[1] + tokens[2], producePredicate(tokens[1], tokens[2]));
            } else {
                predicates.remove(tokens[1] + tokens[2]);
            }

            input = scanner.nextLine();


        }

        names.stream()
                .filter(n -> {
                    boolean isValid = true;
                    for (Predicate<String> predicate : predicates.values()) {
                        if (predicate.test(n)) {
                            isValid = false;
                            break;
                        }
                    }
                    return isValid;
                }).forEach(e -> System.out.print(e + " "));
    }

    public static Predicate<String> producePredicate(String command, String param) {
        Predicate<String> check;
        switch (command) {
            case "Starts with":
                check = str -> str.startsWith(param);
                break;
            case "Ends with":
                check = str -> str.endsWith(param);
                break;
            case "Length":
                check = str -> str.length() == Integer.parseInt(param);
                break;
            case "Contains":
                check = str -> str.contains(param);
                break;
            default:
                return null;
        }
        return check;
    }
}
