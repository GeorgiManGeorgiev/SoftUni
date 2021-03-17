package A_PB.OldExams;

import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int clientCount = Integer.parseInt(scanner.nextLine());
        String input = "";
        double totalBill = 0;


        for (int i = 1; i <= clientCount; i++) {
            double billForClient = 0;
            int itemsCount = 0;
            while (true) {
                input = scanner.nextLine();
                switch (input) {
                    case "basket":
                        billForClient += 1.50;
                        itemsCount++;
                        break;
                    case "wreath":
                        billForClient += 3.8;
                        itemsCount++;
                        break;
                    case "chocolate bunny":
                        billForClient += 7;
                        itemsCount++;
                        break;
                }

                if (input.equals("Finish")) {
                    if (itemsCount % 2 == 0)
                        billForClient *= 0.8;
                    totalBill += billForClient;
                    System.out.printf("You purchased %d items for %.2f leva.%n", itemsCount, billForClient);
                    break;
                }

            }
        }
        double avr = totalBill / clientCount;
        System.out.printf("Average bill per client is: %.2f leva.", avr);

    }
}
