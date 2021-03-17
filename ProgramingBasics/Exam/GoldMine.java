package A_PB.Exam;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int locationsCount = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= locationsCount; i++) {

            double expectedGoldFromLocation = Double.parseDouble(scanner.nextLine());
            int daysAtLocation = Integer.parseInt(scanner.nextLine());

            double goldFromL = 0;
            double avrGForL = 0;

            for (int j = 1; j <= daysAtLocation; j++) {
                double goldToday = Double.parseDouble(scanner.nextLine());
                goldFromL += goldToday;

            }
            avrGForL =  goldFromL / daysAtLocation;
            if (avrGForL >= expectedGoldFromLocation) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", avrGForL);
            } else {
                double result = expectedGoldFromLocation - avrGForL;
                System.out.printf("You need %.2f gold.%n", result);
            }
        }
    }
}
