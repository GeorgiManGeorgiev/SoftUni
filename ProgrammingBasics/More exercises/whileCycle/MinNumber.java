package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int min = Integer.MAX_VALUE;
        while (count < n) {
            int num = Integer.parseInt(scanner.nextLine());
            count++;
            if (num < min ) {
                min = num;
            }
        }System.out.println(min);
    }
}
