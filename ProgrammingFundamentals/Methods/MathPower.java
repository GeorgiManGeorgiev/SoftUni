package B_FM.Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        double value = mathPower(x, n);

        System.out.println(new DecimalFormat("0.####").format(value));
    }

    public static double mathPower(double num, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }
}
