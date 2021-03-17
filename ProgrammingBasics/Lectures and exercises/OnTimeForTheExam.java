package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hourOfExam = Integer.parseInt(scanner.nextLine());
        int minutesOfExam = Integer.parseInt(scanner.nextLine());
        int hourOfArrival = Integer.parseInt(scanner.nextLine());
        int minutesOfArrival = Integer.parseInt(scanner.nextLine());

        int examMinutes = (hourOfExam * 60) + minutesOfExam;
        int arrivalMinutes = (hourOfArrival * 60) + minutesOfArrival;
        int difference = examMinutes - arrivalMinutes;
        double hour = 0;
        double min = 0;

        if (difference <= 30 && difference > 0) {
            System.out.printf("On time %d minutes before the start", difference);
        } else if (difference == 0) {
            System.out.println("On time");
        } else if (difference < 0 && difference >= -59) {
            difference = Math.abs(difference);
            System.out.printf("Late %d minutes after the start", difference);
        } else if (difference > 30 && difference <= 59) {
            System.out.printf("Early %d minutes before the start", difference);
        } else if (difference >= 60) {
            min = difference % 60;
            hour = Math.floor(difference / 60);
            if(min<10){
                System.out.printf("Early %.0f:0%.0f hours before the start", hour, min);
            }else{
            System.out.printf("Early %.0f:%.0f hours before the start", hour, min);
            }
        } else if (difference <= -60) {
            difference = Math.abs(difference);
            min = difference % 60;
            hour = Math.floor(difference / 60);
            if(min<10){
                System.out.printf("Late %.0f:0%.0f hours after the start", hour, min);
            }else{
            System.out.printf("Late %.0f:%.0f hours after the start", hour, min);
            }
        }
    }
}