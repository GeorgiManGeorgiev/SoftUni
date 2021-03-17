package B_FM.nextLectures.basic;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int number = begin; number <= end; number++) {
            System.out.print(number);
            System.out.print(" ");
            sum += number;

        }
        System.out.printf("%nSum: %d", sum);
    }
}
