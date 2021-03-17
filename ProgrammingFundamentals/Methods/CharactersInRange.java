package B_FM.Methods;


import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        printCharBetween(first, second);

    }

    private static void printCharBetween(char first, char second) {
        String output = "";
        if (second > first) {
            for (char symbol = (char) (first + 1); symbol < second; symbol++) {
                output += symbol + " ";
            }
        } else {
            for (char symbol = (char) (second + 1); symbol < first; symbol++) {
                output += symbol + " ";
            }
        }
        System.out.println(output);
    }

}

