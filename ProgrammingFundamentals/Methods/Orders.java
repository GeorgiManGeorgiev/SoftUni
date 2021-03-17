package B_FM.Methods;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        printResult(input,quantity);

    }

    private static void printResult(String input, int n) {
        double result = 0;
        switch (input) {
            case "coffee":
                result = n * 1.5;
                break;
            case "water":
                result = n * 1.00;
                break;
            case "coke":
                result = n * 1.40;
                break;
            case "snacks":
                result = n * 2.00;
                break;
        }
        System.out.printf("%.2f", result);
    }
}
