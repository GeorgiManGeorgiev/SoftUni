package A_PB.OldExams;

import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;
        for (int i = 1; i <= days; i++) {
            double priceForTheDay = 0;
            double pricePerH = 1;
            for (int j = 1; j <= hours; j++) {
                if (i % 2 == 0 && j % 2 == 1) {
                    pricePerH = 2.50;
                }
                if (i % 2 == 1 && j % 2 == 0) {
                    pricePerH = 1.25;
                }
                priceForTheDay+=pricePerH;
                totalPrice += pricePerH;
                pricePerH = 1;

            }
            System.out.printf("Day: %d - %.2f leva%n", i, priceForTheDay );
        }
        System.out.printf("Total: %.2f leva",totalPrice);
    }
}
