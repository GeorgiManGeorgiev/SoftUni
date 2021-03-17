package B_FM.nextLectures.Arrays;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                firstArr[i] = first;
                secondArr[i] = second;
            } else {
                int second = scanner.nextInt();
                int first = scanner.nextInt();
                firstArr[i] = first;
                secondArr[i] = second;
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(firstArr[j] + " ");

        }
        System.out.println();
        for (int j = 0; j < n; j++) {
            System.out.print(secondArr[j] + " ");
        }
    }
}
