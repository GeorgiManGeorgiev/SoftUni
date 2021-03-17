package B_FM.Methods;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            System.out.println(isItPalindrome(input));
            input = scanner.nextLine();
        }
    }

    private static boolean isItPalindrome(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            char curr = input.charAt(i);
            reversed += curr;
        }
        if (input.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }
}
