package B_FM.TextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char baseLetter = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char curr = input.charAt(i);

            if (baseLetter != curr) {
                sb.append(baseLetter);
                baseLetter = curr;
            }
            if (i == input.length()-1){
                sb.append(input.charAt(i));
            }

        }

        System.out.println(sb.toString());
    }
}
