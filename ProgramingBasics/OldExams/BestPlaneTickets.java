package A_PB.OldExams;

import java.util.Scanner;

public class BestPlaneTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int minMinutes = 500;
        String flightMinMinutes = "";
        double priceOfTicketMinMinutes = 0;

        while (!input.equals("End")) {
            double priceOfTicket = Double.parseDouble(scanner.nextLine());
            int minStay = Integer.parseInt(scanner.nextLine());
            if (minStay < minMinutes) {
                minMinutes = minStay;
                flightMinMinutes = input;
                priceOfTicketMinMinutes = priceOfTicket;
            }

            input = scanner.nextLine();
        }
        double priceInLv = priceOfTicketMinMinutes*1.96;
        int hours = minMinutes/60;
        int min = minMinutes%60;
        System.out.printf("Ticket found for flight %s costs %.2f leva with %dh %dm stay",flightMinMinutes,priceInLv,hours,min);
    }
}
