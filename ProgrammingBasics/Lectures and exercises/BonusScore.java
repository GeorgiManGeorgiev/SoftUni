package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        double bonus;
        if (num > 1000) {
            bonus = num * 0.1;
        } else if (num > 100) {
            bonus = num * 0.2;
        } else {
            bonus = 5;
        }
        if (num % 2 == 0) {
            bonus += 1;
        } else if (num % 10 == 5) {
            bonus += 2;
        }
        System.out.println(bonus);
        System.out.println(num + bonus);
    }
}
