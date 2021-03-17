package B_FM.TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numAsString = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        if (multiplier == 0) {
            System.out.println(0);
            return;
        }

        while (numAsString.charAt(0) == '0') {
            numAsString = numAsString.substring(1);
        }

        StringBuilder result = new StringBuilder();
        int remainder = 0;
        for (int i = numAsString.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(numAsString.charAt(i)));
            int product = digit * multiplier + remainder;
            result.append(product % 10);
            remainder = product / 10;
        }
        if (remainder != 0) {
            result.append(remainder);
        }
        System.out.println(result.reverse());
    }
}
