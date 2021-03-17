package A_PB.OldExams;

import java.util.Scanner;

public class Seats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ticketCount = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <=ticketCount ; i++) {
            String ticketNumber = scanner.nextLine();

            char first = ticketNumber.charAt(0);
            char second = ticketNumber.charAt(1);
            char third = ticketNumber.charAt(2);
            char fourth= ticketNumber.charAt(3);


            int ticketLength = ticketNumber.length();

                if (ticketLength==4){
                    if(!(first>='A' && first<='Z')){
                        System.out.printf("Seat decoded: %s%s%s%n",fourth,second,third);
                    }else {
                        System.out.printf("Seat decoded: %s%s%s%n",first,second,third);
                    }
                }if (ticketLength==5 || ticketLength==6){
                    int secondInt = (int)second;
                System.out.printf("Seat decoded: %s%d%n",first,secondInt);
            }

        }

    }
}
