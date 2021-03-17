package A_PB.ExamPreparation;

import java.util.Scanner;

public class WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String championship = scanner.nextLine();
        String ticketType = scanner.nextLine();
        int countTicket = Integer.parseInt(scanner.nextLine());
        String picture = scanner.nextLine();
        double ticketPrice = 0;

        switch (championship) {
            case "Quarter final":
                switch (ticketType) {
                    case "Standard":
                        ticketPrice = 55.5;
                        break;
                    case "Premium":
                        ticketPrice = 105.2;
                        break;
                    case "VIP":
                        ticketPrice = 118.9;
                        break;
                }
                break;
            case "Semi final":
                switch (ticketType) {
                    case "Standard":
                        ticketPrice = 75.88;
                        break;
                    case "Premium":
                        ticketPrice = 125.22;
                        break;
                    case "VIP":
                        ticketPrice = 300.4;
                        break;
                }
                break;
            case "Final":
                switch (ticketType) {
                    case "Standard":
                        ticketPrice = 110.1;
                        break;
                    case "Premium":
                        ticketPrice = 160.66;
                        break;
                    case "VIP":
                        ticketPrice = 400;
                        break;
                }
                break;
        }
        double totalPrice = ticketPrice * countTicket;
        if (totalPrice > 4000) {
            totalPrice *= 0.75;
        } else if (totalPrice > 2500) {
            totalPrice *= 0.9;
            if (picture.equals("Y")) {
                double pictureTotalPrice = countTicket * 40;
                totalPrice += pictureTotalPrice;
            }
        } else if (picture.equals("Y"))  {
            double pictureTotalPrice = countTicket * 40;
            totalPrice += pictureTotalPrice;
        }
        System.out.printf("%.2f", totalPrice);
    }
}

