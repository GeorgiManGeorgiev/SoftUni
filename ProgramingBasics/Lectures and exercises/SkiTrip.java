package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysCount = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String feedback = scanner.nextLine();
        double pricePerNight = 0;
        double discount = 0;
        switch (roomType) {
            case "room for one person":
                pricePerNight = 18;
                break;
            case "apartment":
                pricePerNight = 25;
                if (daysCount < 10) {
                    discount = 0.3;
                } else if (daysCount >= 10 && daysCount <= 15) {
                    discount = 0.35;
                } else if (daysCount > 15) {
                    discount = 0.5;
                }
                break;
            case "president apartment":
                pricePerNight = 35;
                if (daysCount < 10) {
                    discount = 0.1;
                } else if (daysCount >= 10 && daysCount <= 15) {
                    discount = 0.15;
                } else if (daysCount > 15) {
                    discount = 0.2;
                }
                break;
        }
        int nights = daysCount - 1;
        double totalSum = nights * pricePerNight;
        totalSum -= totalSum * discount;
        if (feedback.equals("positive")) {
            totalSum += totalSum * 0.25;
        } else {
            totalSum -= totalSum * 0.1;
        }
        System.out.printf("%.2f", totalSum);

    }
}
