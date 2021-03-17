package A_PB.OldExams;

import java.util.Scanner;

public class SummerShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        double priceOfTowel = Double.parseDouble(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double priceOfUmbrella = priceOfTowel * 2 / 3;
        double priceOfFlipFlops = priceOfUmbrella * 0.75;
        double priceOfBag = (priceOfFlipFlops + priceOfTowel) * 1 / 3;

        double price = priceOfTowel + priceOfUmbrella + priceOfFlipFlops + priceOfBag;
        price = price - (price*discount/100);
        double diff = Math.abs(budget-price);
        if (budget>=price){
            System.out.printf("Annie's sum is %.2f lv. She has %.2f lv. left.",price,diff);
        }else {
            System.out.printf("Annie's sum is %.2f lv. She needs %.2f lv. more.",price,diff);
        }


    }
}
