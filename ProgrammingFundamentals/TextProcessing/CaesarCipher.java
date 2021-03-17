package B_FM.TextProcessing;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char letter = (char) (message.charAt(i) + 3);
            sb.append(letter);
        }
        System.out.println(sb.toString());
    }
}
