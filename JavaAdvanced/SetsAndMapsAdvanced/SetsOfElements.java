package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();
        Set<Integer> repeated = new LinkedHashSet<>();
        for (int i = 1; i <= n + m; i++) {

            int number = Integer.parseInt(scanner.nextLine());
            if (i <= n) {
                first.add(number);
            } else {
                second.add(number);
            }
        }
        for (Integer num1 : first) {
            for (Integer num2 : second) {
                if (num1 == num2) {
                    repeated.add(num1);
                }
            }
        }

        for (Integer numToPrint : repeated) {
            System.out.print(numToPrint + " ");
        }
    }
}
