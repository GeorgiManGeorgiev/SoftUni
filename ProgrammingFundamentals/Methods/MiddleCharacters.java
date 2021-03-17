package B_FM.Methods;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printMiddleChar(input);
    }

    private static void printMiddleChar(String input) {
        int middle = 0;
        if (input.length() % 2 == 0) {
            middle = (input.length() / 2) - 1;
            System.out.print(input.charAt(middle));
            System.out.print(input.charAt(middle + 1));
        } else {

            middle = (int) input.length() / 2;
            System.out.println(input.charAt(middle));


        }
    }
}
