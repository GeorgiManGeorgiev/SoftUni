package B_FM.nextLectures.basic;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayType = scanner.nextLine();

        double price = 0;
        double totalPrice = 0;
        if (groupType.equals("Students")) {
            if (dayType.equals("Friday")) {
                price = 8.45;
            }
            if (dayType.equals("Saturday")) {
                price = 9.80;
            }
            if (dayType.equals("Sunday")) {
                price = 10.46;
            }
            totalPrice = peopleCount * price;
            if (peopleCount >= 30) {
                totalPrice *= 0.85;
            }
        }
        if (groupType.equals("Business")) {
            if (dayType.equals("Friday")) {
                price = 10.90;
            }
            if (dayType.equals("Saturday")) {
                price = 15.60;
            }
            if (dayType.equals("Sunday")) {
                price = 16;
            }
            totalPrice = peopleCount * price;
            if (peopleCount >= 100) {
                totalPrice = (peopleCount - 10) * price;
            }
        }
        if (groupType.equals("Regular")) {
            if (dayType.equals("Friday")) {
                price = 15;
            }
            if (dayType.equals("Saturday")) {
                price = 20;
            }
            if (dayType.equals("Sunday")) {
                price = 22.50;
            }
            totalPrice = peopleCount * price;
            if (peopleCount >= 10 && peopleCount <= 20) {
                totalPrice *= 0.95;
            }
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
