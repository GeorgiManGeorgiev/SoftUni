package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int i = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                if (i > n) {
                    return;
                }
                System.out.print(i + " ");
                i++;
            }
            System.out.println();
        }
    }
}
