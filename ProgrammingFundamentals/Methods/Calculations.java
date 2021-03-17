package B_FM.Methods;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        printResult(a, input, b);
    }

    private static void printResult(int a, String operator, int b) {
        int result = 0;
        switch (operator) {
            case "add":
                result = a + b;
                break;
            case "multiply":
                result = a * b;
                break;
            case "subtract":
                result = a - b;
                break;
            case "divide":
                result = a / b;
                break;
        }
        System.out.println(result);
    }
}
