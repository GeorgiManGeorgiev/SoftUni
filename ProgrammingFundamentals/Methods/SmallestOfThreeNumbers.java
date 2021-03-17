package B_FM.Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int result = getSmallest(a, b, c);
        System.out.println(result);
    }

    private static int getSmallest(int a, int b, int c) {
        if (getSmallest(a, b) < c) {
            return getSmallest(a, b);
        } else {
            return c;
        }
    }

    private static int getSmallest(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}
