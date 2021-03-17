package B_FM.Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println(new DecimalFormat("0.##").format(calculate(a, input, b)));


    }

    private static double calculate(double a, String operator, double b) {
        double result = 0;
        if (operator.equals("*")) {
            result = a * b;
        }
        if (operator.equals("/")) {
            result = a / b;
        }
        if (operator.equals("+")) {
            result = a + b;
        }
        if (operator.equals("-")) {
            result = a - b;
        }
        return result;
    }
}
