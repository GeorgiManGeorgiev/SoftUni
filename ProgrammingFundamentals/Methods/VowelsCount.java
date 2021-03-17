package B_FM.Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = getVowelsCount(input);
        System.out.println(result);

    }

    private static int getVowelsCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            switch (curr) {
                case 'A':
                case 'a':
                case 'E':
                case 'e':
                case 'I':
                case 'i':
                case 'O':
                case 'o':
                case 'U':
                case 'u':
                case 'Y':
                case 'y':
                    count++;
                    break;
            }
        }
        return count;
    }
}
