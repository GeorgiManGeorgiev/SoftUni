package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        String changeAsString = String.format("%.0f", Math.floor(change * 100));
        int st = Integer.parseInt(changeAsString);
        int count = 0;


        while (st > 0) {
            if (st >= 200) {
                st -= 200;
                count++;
            } else if (st >= 100) {
                st -= 100;
                count++;
            } else if (st >= 50) {
                st -= 50;
                count++;
            } else if (st >= 20) {
                st -= 20;
                count++;
            } else if (st >= 10) {
                st -= 10;
                count++;
            } else if (st >= 5) {
                st -= 5;
                count++;
            } else if (st >= 2) {
                st -= 2;
                count++;
            }else if (st >= 1) {
                st -= 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
