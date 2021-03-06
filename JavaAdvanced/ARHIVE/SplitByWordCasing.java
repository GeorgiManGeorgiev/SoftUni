package C_JavaAdvanced.JavaAdv.ARHIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("[\\\\,;:.!()\"\'/\\[\\] ]");

        List<String> lowerCase = new ArrayList<>();
        List<String> upperCase = new ArrayList<>();
        List<String> mixedCase = new ArrayList<>();

        for (String word : words) {
            if (word.trim().length()==0){
                continue;
            }

            boolean isMixed = false;
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetter(word.charAt(i) )) {
                    mixedCase.add(word);
                    isMixed = true;
                    break;
                }
            }
            if (!isMixed) {
                if (word.toUpperCase().equals(word)) {
                    upperCase.add(word);
                } else if (word.toLowerCase().equals(word)) {
                    lowerCase.add(word);
                } else {
                    mixedCase.add(word);
                }
            }
        }

        System.out.printf("Lower-case: %s%n", String.join(", ", lowerCase));
        System.out.printf("Mixed-case: %s%n", String.join(", ", mixedCase));
        System.out.printf("Upper-case: %s%n", String.join(", ", upperCase));
    }
}
