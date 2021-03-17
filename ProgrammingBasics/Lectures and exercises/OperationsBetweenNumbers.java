package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        switch (operator) {
            case "+": {
                int result = n1 + n2;
                if (result % 2 == 0) {
                    System.out.println(n1 + " + " + n2 + " = " + result + " - even");
                } else
                    System.out.println(n1 + " + " + n2 + " = " + result + " - odd");
            }
            break;
            case "*": {
                int result = n1 * n2;
                if (result % 2 == 0) {
                    System.out.printf("%d * %d = %d - even", n1, n2, result);
                } else
                    System.out.printf("%d * %d = %d - odd", n1, n2, result);
            }
            break;
            case "/": {
                double result = (n1 * 1.0) / n2;
                if (n2 == 0) {
                    System.out.println("Cannot divide " + n1 + " by zero");
                } else{
                    System.out.printf("%d / %d = %.2f", n1, n2, result);
                }
            }
            break;
            case "-": {
                int result = n1 - n2;
                if (result % 2 == 0) {
                    System.out.printf("%d - %d = %d - even", n1, n2, result);
                } else
                    System.out.printf("%d - %d = %d - odd", n1, n2, result);
            }
            break;
            case "%": {
                if (n1 == 0) {
                    System.out.println("Cannot divide " + n1 + " by zero");
                } else {
                    double result = n1 % n2;
                    System.out.printf("%d %% %d = %.0f", n1, n2, result);
                }
            }break;
        }

    }
}


