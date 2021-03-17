package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstSeconds = Integer.parseInt(scanner.nextLine());
        int secondSeconds = Integer.parseInt(scanner.nextLine());
        int thirdSeconds = Integer.parseInt(scanner.nextLine());
        int totalSeconds = firstSeconds + secondSeconds + thirdSeconds;
        int min = totalSeconds / 60;
        int sec = totalSeconds % 60;
        if (sec < 10) {
            System.out.printf("%d:0%d", min, sec);
        } else {
            System.out.println(min + ":" + sec);
        }
    }

}

