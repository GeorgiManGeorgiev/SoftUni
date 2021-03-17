package A_PB.ExamPreparation;

import java.util.Scanner;

public class ChristmasMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());
        int countFantasy = Integer.parseInt(scanner.nextLine());
        int horrorCount = Integer.parseInt(scanner.nextLine());
        int romanceCount = Integer.parseInt(scanner.nextLine());

        double sumFantasy = countFantasy * 14.90;
        double sumHorror = horrorCount * 9.80;
        double sumRomance = romanceCount * 4.30;

        double allSum = sumFantasy + sumHorror + sumRomance;

        double sumWithoutVAT = allSum - (allSum * 0.2);


        if (sum < sumWithoutVAT) {
            double diff = sumWithoutVAT - sum;
            double bonus = Math.floor(diff * 0.1);
            double sumCharity = (diff - bonus) + sum;
            System.out.printf("%.2f leva donated.%nSellers will receive %.0f leva.",
                    sumCharity, bonus);
        }else{
            double diff = sum - sumWithoutVAT;
            System.out.printf("%.2f money needed.",diff);
        }


    }
}
