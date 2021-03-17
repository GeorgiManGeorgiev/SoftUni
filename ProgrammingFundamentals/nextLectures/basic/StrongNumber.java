package B_FM.nextLectures.basic;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int numberAsInt = Integer.parseInt(number);
        int numAsIntLength = number.length();
        int sum = 0;
        for (int i = 0; i <= numAsIntLength - 1; i++) {
            char curr = number.charAt(i);
            int current = Integer.parseInt(String.valueOf(curr));
            int j, fact = 1;
            for (j = 1; j <= current; j++) {
                fact = fact * j;
            }
            sum += fact;

        }
        if (sum == numberAsInt) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
