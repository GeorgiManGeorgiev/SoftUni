package A_PB.OldExams;

import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayOfReservation = Integer.parseInt(scanner.nextLine());
        int mountOfReservation = Integer.parseInt(scanner.nextLine());
        int dayOfEntering = Integer.parseInt(scanner.nextLine());
        int mountOfEntering = Integer.parseInt(scanner.nextLine());
        int dayOfLeave = Integer.parseInt(scanner.nextLine());
        int mountOfLeave = Integer.parseInt(scanner.nextLine());

        double priceOfDay = 30;

        int days = dayOfLeave - dayOfEntering;
        int diffBtwResAndEnter = dayOfEntering-dayOfReservation;

        if (diffBtwResAndEnter>=10){
            priceOfDay=25;
        }
        if (mountOfReservation < mountOfEntering) {
            priceOfDay=25;
            priceOfDay = priceOfDay * 0.8;

        }
        double cost = days * priceOfDay;
        System.out.printf("Your stay from %d/%d to %d/%d will cost %.2f",dayOfEntering,mountOfEntering,dayOfLeave,mountOfLeave,cost);
    }
}
