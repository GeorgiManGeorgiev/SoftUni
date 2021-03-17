package C_JavaAdvanced.JavaAdv.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = s-> System.out.println(s );

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e->printer.accept(e));
    }
}
