package A_PB.pastLectures.forCycle;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int lastSum = 0;
        int maxDiff = 0;
        for (int i = 1; i <= n; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());
            int sum = num1 + num2;
            if (i > 1) {
                if (lastSum != sum) {
                    int diff = Math.abs(lastSum - sum);
                    if (diff > maxDiff) {
                        maxDiff = diff;

                    }
                }
            }
            lastSum = sum;
        }
        if (maxDiff == 0) {
            System.out.printf("Yes, value=%d", lastSum);
        }else {
            System.out.printf("No, maxdiff=%d",maxDiff);
        }
    }
}
