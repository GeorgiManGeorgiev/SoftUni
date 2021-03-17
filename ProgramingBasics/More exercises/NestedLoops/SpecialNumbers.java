package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i < 9999; i++) {
            int currentNumber = i;
            boolean isSpecial = false;
            while (currentNumber > 0) {
                int lastDigit = currentNumber % 10;
                if ((lastDigit != 0) && (n % lastDigit == 0)) {
                    isSpecial = true;
                } else {
                    isSpecial = false;
                    break;
                }
                currentNumber /= 10;
            }
            if (isSpecial)
                System.out.printf("%d ", i);
        }

    }
}
