package A_PB.OldExams;

import java.util.Scanner;

public class LuggageTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int high = Integer.parseInt(scanner.nextLine());
        int depth = Integer.parseInt(scanner.nextLine());
        String  priority = scanner.nextLine();
        double tax = 0;

        int result = width*high*depth;
        if (priority.equals("true")){
            if (result>50 && result<=100){
                tax = 0;
            }if (result>100 && result<=200){
                tax = 10;
            }if (result>200 && result<=300){
                tax = 20;
            }

        }else{
            if (result>50 && result<=100){
                tax = 25;
            }if (result>100 && result<=200){
                tax = 50;
            }if (result>200 && result<=300){
                tax = 100;
            }
        }
        System.out.printf("Luggage tax: %.2f",tax);

    }
}
