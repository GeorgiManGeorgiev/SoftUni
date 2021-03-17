package B_FM.Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (checkIfIsBetween(input) && checkIfContains(input) && checkIfHaveTwoDigits(input)) {
            System.out.println("Password is valid");
        }if (!checkIfIsBetween(input)){
            System.out.printf("Password must be between 6 and 10 characters%n");
        }if(!checkIfContains(input)){
            System.out.printf("Password must consist only of letters and digits%n");
        }if (!checkIfHaveTwoDigits(input)){
            System.out.printf("Password must have at least 2 digits%n");
        }

    }

    private static boolean checkIfIsBetween(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean checkIfContains(String password) {

        for (int i = 0; i < password.length(); i++) {

            char symbol = password.charAt(i);
            boolean isDigit = Character.isDigit(symbol);
            boolean isLetter = Character.isLetter(symbol);

            if (!isDigit && !isLetter) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfHaveTwoDigits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (Character.isDigit(symbol)) {
                count++;
            }
        }

        if (count >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
