package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int stayCount = Integer.parseInt(scanner.nextLine());

        double stayPriceForStudios = 0;
        double stayPriceForApartments = 0;
        double studioPrice = 0;
        double apartmentPrice = 0;
        switch (month) {
            case "May":
            case "October": {
                studioPrice = 50;
                apartmentPrice = 65;
            }break;
            case "June":
            case "September": {
                studioPrice = 75.20;
                apartmentPrice = 68.70;
            }
            break;
            case "July":
            case "August": {
                studioPrice = 76;
                apartmentPrice = 77;
            }
           break;
        }
        if((month.equals("May") || month.equals("October"))){
            if (stayCount>7 && stayCount<14){
                studioPrice -= studioPrice * 0.05;
            }else if (stayCount>14) {
                studioPrice -= studioPrice * 0.3;
            }
        }
        else if ((month.equals("June") || month.equals("September"))) {
            if (stayCount>14) {
                studioPrice -= studioPrice * 0.2;
            }
        }if (stayCount>14){
            apartmentPrice -= apartmentPrice * 0.1;
        }
        stayPriceForApartments = apartmentPrice *stayCount;
        stayPriceForStudios = studioPrice * stayCount;

        System.out.printf("Apartment: %.2f lv. %n",stayPriceForApartments);
        System.out.printf("Studio: %.2f lv.",stayPriceForStudios);

    }
}

