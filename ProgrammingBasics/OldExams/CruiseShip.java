package A_PB.OldExams;

import java.util.Scanner;

public class CruiseShip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfCruise = scanner.nextLine();
        String typeOfRoom = scanner.nextLine();
        int stayCount = Integer.parseInt(scanner.nextLine());
        double price = 0;
        if (typeOfCruise.equals("Mediterranean")) {
            if (typeOfRoom.equals("standard cabin")) {
                price = 27.50;
            }
            if (typeOfRoom.equals("cabin with balcony")) {
                price = 30.20;
            }
            if (typeOfRoom.equals("apartment")) {
                price = 40.50;
            }
        }
        if (typeOfCruise.equals("Adriatic")) {
            if (typeOfRoom.equals("standard cabin")) {
                price = 22.99;
            }
            if (typeOfRoom.equals("cabin with balcony")) {
                price = 25.00;
            }
            if (typeOfRoom.equals("apartment")) {
                price = 34.99;
            }
        }
        if (typeOfCruise.equals("Aegean")) {
            if (typeOfRoom.equals("standard cabin")) {
                price = 23.00;
            }
            if (typeOfRoom.equals("cabin with balcony")) {
                price = 26.60;
            }
            if (typeOfRoom.equals("apartment")) {
                price = 39.80;
            }
        }
        double priceOfStay = price * 4 * stayCount;
        if (stayCount>7){
            priceOfStay*=0.75;
        }
        System.out.printf("Annie's holiday in the %s sea costs %.2f lv.",typeOfCruise,priceOfStay);
    }
}
