package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String type = null;
        String destination = null;
        double expenses = 0;

        if (budget > 1000) {
            destination = "Europe";
            expenses = budget * 0.9;
            type = "Hotel";
        } else if (budget > 100) {
            destination = "Balkans";
            if (season.equalsIgnoreCase("winter")) {
                expenses = budget * 0.8;
            } else if (season.equalsIgnoreCase("summer")) {
                expenses = budget * 0.4;
            }
        } else if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equalsIgnoreCase("winter")) {
                expenses = budget * 0.7;
            } else if (season.equalsIgnoreCase("summer")) {
                expenses = budget * 0.3;
            }
        }
        if (!destination.equalsIgnoreCase("Europe")) {
            if (season.equalsIgnoreCase("Winter")) {
                type = "Hotel";
            } else {
                type = "Camp";
            }
        }
        System.out.printf("Somewhere in %s %n",destination);
        System.out.printf("%s - %.2f", type, expenses);
    }
}
