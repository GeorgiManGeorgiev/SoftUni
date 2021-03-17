package C_JavaAdvanced.JavaAdv.FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input   = scanner.nextLine();

        while (!input.equals("Party!")){
            String[] tokens = input.split("\\s+");

            Predicate<String> predicate = producePredicate(tokens[1],tokens[2]);

            switch (tokens[0]){
                case"Remove":
                    names.removeIf(predicate::test);
                    break;
                case"Double":
                    List<String> namesToAdd = new ArrayList<>();
                    for (String name : names) {
                      if (predicate.test(name)){
                          namesToAdd.add(name);
                      }
                    }
                    names.addAll(namesToAdd);
                    break;
            }


            input = scanner.nextLine();
        }
        Collections.sort(names);
        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.print(String.join(", ", names));
            System.out.print(" are going to the party!");

        }
    }

    private static Predicate<String> producePredicate(String command, String param) {
    Predicate<String> check ;
        switch (command){
            case "StartsWith":
                check = str->str.startsWith(param);
                break;
            case "EndsWith":
                check = str->str.endsWith(param);
                break;
            case "Length":
                check = str->str.length() == Integer.parseInt(param);
                break;
            default: return null;
        }
        return check;
    }
}
