package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new HashSet<>();
        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                String curr = input[j];
                elements.add(curr);
            }
        }
        elements
                .stream()
                .sorted((e1, e2) -> e1.compareTo(e2)).forEach(el -> System.out.print(el + " "));

    }
}
