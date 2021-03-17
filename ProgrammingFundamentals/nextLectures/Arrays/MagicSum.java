package B_FM.nextLectures.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input.length; i++) {

            for (int j = i + 1; j < input.length; j++) {
                if (num == input[i] + input[j]) {

                    System.out.println(input[i] + " " + input[j]);
                }
            }
        }
    }
}
