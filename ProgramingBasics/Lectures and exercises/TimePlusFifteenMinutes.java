package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class TimePlusFifteenMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int totalMinutes = hours * 60 + minutes;
        totalMinutes += 15;
        int newHour = totalMinutes / 60;
        int newMinutes = totalMinutes % 60;
        if (newHour > 23) {
            newHour = 0;
        }
        if (newMinutes < 10) {
            System.out.printf("%d:0%d", newHour, newMinutes);
        } else {
            System.out.println(newHour + ":" + newMinutes);
        }
    }
}
