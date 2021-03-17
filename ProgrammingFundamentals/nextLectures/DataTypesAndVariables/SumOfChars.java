package B_FM.nextLectures.DataTypesAndVariables;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int  sum = 0;
        while (n-- > 0) {
            String input = scanner.nextLine();
            char symbol = input.charAt(0);
            sum+=symbol;

        }
        System.out.println("The sum equals: "+sum);
    }
}
