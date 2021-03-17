package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projection = scanner.nextLine();
        int row = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        double premiere = 12.00;
        double normal = 7.50;
        double discount = 5.00;
        int seats = row * columns;
        double income = 0.0;
        switch (projection) {
            case "Premiere":
                income = seats * premiere;
                break;
            case "Normal":
                income = seats * normal;
                break;
            case "Discount":
                income = seats * discount;
                break;
        }
        System.out.printf("%.2f leva",income);
    }
}
