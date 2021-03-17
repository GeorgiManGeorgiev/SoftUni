package B_FM.AssociativeArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        String[] wordsFiltered = Arrays.stream(words)
                .filter(w -> w.length() % 2 == 0)
                .toArray(String[]::new);

        for (String s : wordsFiltered) {
            System.out.println(s);
        }
    }
}
