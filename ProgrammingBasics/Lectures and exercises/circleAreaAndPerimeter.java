package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class circleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double calculatedArea = Math.PI * Math.pow(r, 2);
        double calculatedPerimeter = 2 * r * Math.PI;
        System.out.printf("%.2f", calculatedArea);
        System.out.println();
        System.out.printf("%.2f", calculatedPerimeter);
    }
}
