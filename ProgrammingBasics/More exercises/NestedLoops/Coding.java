package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int length = input.length();

        for (int i = length - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            int currentCharAsNumber = Integer.parseInt(Character.toString(currentChar));
            if (currentCharAsNumber == 0) {
                System.out.print("ZERO");
            } else {

                char newChar = (char) (currentCharAsNumber + 33);
                for (int j = 0; j < currentCharAsNumber; j++) {
                    System.out.print(newChar);
                }
            }
            System.out.println();
        }
    }
}
