package B_FM.Methods;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        System.out.println(subtractThirdAndSum(a, b, c));

    }

    private static int subtractThirdAndSum(int a, int b, int c) {
        return addFirstAndSecond(a, b) - c;
    }

    private static int addFirstAndSecond(int a, int b) {
        return a + b;
    }
}
