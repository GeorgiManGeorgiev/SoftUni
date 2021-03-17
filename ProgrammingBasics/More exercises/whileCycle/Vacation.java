package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyForTrip = Double.parseDouble(scanner.nextLine());
        double moneyWeHave = Double.parseDouble(scanner.nextLine());
        boolean areMoneySaved = true;
        int spendCount = 0;
        int days = 0;
        while (moneyWeHave < moneyForTrip) {
            days++;
            String command = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            switch (command) {
                case "save":
                    moneyWeHave += money;
                    spendCount = 0;
                    break;
                case "spend":
                    spendCount++;
                    moneyWeHave -= money;
                    if (moneyWeHave < 0) {
                        moneyWeHave = 0;
                    }
                    break;
            }
            if (spendCount == 5) {
                areMoneySaved = false;
                break;
            }
        }
        if (areMoneySaved) {
            System.out.printf("You saved the money for %d days.", days);

        } else {
            System.out.println("You can't save the money.");
            System.out.printf("%d", days);
        }

    }
}
