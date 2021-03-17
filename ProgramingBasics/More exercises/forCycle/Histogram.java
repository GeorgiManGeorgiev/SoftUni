package A_PB.pastLectures.forCycle;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 200) {
                p1++;
            }
            if ((number >= 200) && (number <= 399)) {
                p2++;
            }
            if ((number >= 400) && (number <= 599)) {
                p3++;
            }if ((number >= 600) && (number <= 799)) {
                p4++;
            }if (number >= 800) {
                p5++;
            }
        }

        System.out.printf("%.2f%%%n", p1 * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p2 * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p3 * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p4 * 1.0 / n * 100);
        System.out.printf("%.2f%%", p5 * 1.0 / n * 100);
    }
}
