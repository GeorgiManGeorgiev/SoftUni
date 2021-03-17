package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int c = 1;
        while (c <= n) {
            System.out.printf("%d%n", c);
            c = c * 2 + 1;
        }
    }
}
