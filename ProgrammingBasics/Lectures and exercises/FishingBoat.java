package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int peopleCount = Integer.parseInt(scanner.nextLine());

        double boatRent = 0;

        if (season.equals("Spring")) {
            boatRent = 3000;
        }else if (season.equals("Summer")){
            boatRent = 4200;
        }else if (season.equals("Autumn")){
           boatRent = 4200;
        }else if (season.equals("Winter")){
            boatRent = 2600;
        }
        if (peopleCount<=6){
            boatRent -= boatRent * 0.1;
        } else if (peopleCount>=7 && peopleCount<=11){
            boatRent -= boatRent * 0.15;
        }else if (peopleCount>=12){
            boatRent -= boatRent * 0.25;
        }
        int evenPeopleCount = peopleCount % 2;
        if (evenPeopleCount == 0 && !season.equals("Autumn")){
            boatRent -= boatRent * 0.05;
        }double difference = budget - boatRent;
        if (budget>=boatRent){
            System.out.printf("Yes! You have %.2f leva left.",difference);
        }else if (budget<boatRent){
            difference = Math.abs(difference);
            System.out.printf("Not enough money! You need %.2f leva.",difference);
        }
    }
}
