package C_JavaAdvanced.JavaAdv.FunctionalProgramming;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
  private static   List<Integer> numbers;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Map<String, Function<List<Integer>,List<Integer>>> functions = new HashMap<>();
        functions.put("add",e-> e.stream().map(val->val+1)
                   .collect(Collectors.toList()));
        functions.put("subtract",e-> e.stream().map(val->val-1)
                .collect(Collectors.toList()));
        functions.put("multiply",e-> e.stream().map(val->val*2)
                .collect(Collectors.toList()));
        functions.put("print",e-> e.stream().peek(val-> System.out.print( val+" "))
                .collect(Collectors.toList()));
        String input = scanner.nextLine();

        handleInput(functions,scanner,input);


    }

    private static void handleInput(Map<String, Function<List<Integer>, List<Integer>>> functions, Scanner scanner, String input) {
    if (input.equals("end")){
        return;
    }
        numbers = functions.get(input).apply(numbers);
        if (input.equals("print")){
            System.out.println();
        }
        input = scanner.nextLine();
        handleInput(functions,scanner,input);
    }
}
