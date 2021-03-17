package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int symbol1 = 1; symbol1 < n; symbol1++) {
            for (int symbol2 = 1; symbol2 < n; symbol2++) {
                for (char symbol3 = 'a'; symbol3 < 'a' + l; symbol3++) {
                    for (char symbol4 = 'a'; symbol4 < 'a' + l; symbol4++) {
                        for (int symbol5 = 1; symbol5 <= n; symbol5++) {
                            if (symbol5 > symbol1 && symbol5 > symbol2) {
                                System.out.printf("%d%d%c%c%d ", symbol1,
                                        symbol2, symbol3, symbol4, symbol5);
                            }
                        }
                    }
                }
            }
        }
    }
}
