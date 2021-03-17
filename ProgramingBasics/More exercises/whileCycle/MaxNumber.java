package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int max = Integer.MIN_VALUE;
        while (count < n) {
            int num = Integer.parseInt(scanner.nextLine());
            count++;
            if (num > max) {
                max = num;
            }
        }System.out.println(max);
    }
}
