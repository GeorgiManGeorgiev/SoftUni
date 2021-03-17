package A_PB.ExamPreparation;

import java.util.Scanner;

public class ChristmasSweets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double baklavaKgPrice = Double.parseDouble(scanner.nextLine());
        double muffinKgPrice = Double.parseDouble(scanner.nextLine());
        double stolenKg = Double.parseDouble(scanner.nextLine());
        double bonbonsKg = Double.parseDouble(scanner.nextLine());
        double biscuitsKg = Double.parseDouble(scanner.nextLine());
        double stolenPrice = baklavaKgPrice + (baklavaKgPrice * 0.6 );
        double bonbonsPrice = muffinKgPrice + (muffinKgPrice * 0.8 );
        double biscuitsPrice = 7.50;
        double stolenCost = stolenKg * stolenPrice;
        double bonbonsCost = bonbonsKg * bonbonsPrice;
        double biscuitsCost = biscuitsKg * biscuitsPrice;
        double  totalCost = stolenCost + bonbonsCost + biscuitsCost;
        System.out.printf("%.2f",totalCost);


    }
}
