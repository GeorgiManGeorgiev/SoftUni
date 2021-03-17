package B_FM.Methods;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("int")) {
            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(a, b));

        }
        if (input.equals("char")) {
            char a = scanner.nextLine().charAt(0);
            char b = scanner.nextLine().charAt(0);
            System.out.println(getMax(a, b));

        }
        if (input.equals("string")) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(getMax(a, b));

        }

    }

    private static int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private static char getMax(char a, char b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private static String getMax(String a, String b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }
}
