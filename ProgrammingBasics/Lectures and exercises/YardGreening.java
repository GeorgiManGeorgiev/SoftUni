package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read area double m2
        double area = Double.parseDouble(scanner.nextLine());
        // 1 m2 = 7.61 lv. with tax
        double pricePerSqMeter = 7.61;
        double costOfGreening = area * pricePerSqMeter;
        double discount = costOfGreening * 18/100;
        // costs with discount = costs - 18 percents * costs
        // Calculate costs after discounts for greening
        double finalCostOfGreening = costOfGreening - discount;
        //Print The final price is: lv. "%.2f"
        System.out.print("The final price is: ");
        System.out.printf("%.2f", finalCostOfGreening);
        System.out.print(" lv.");
        //Print The discount is: lv. "%.2f"
        System.out.println();
        System.out.print("The discount is: ");
        System.out.printf("%.2f", discount);
        System.out.print(" lv.");
    }
}
