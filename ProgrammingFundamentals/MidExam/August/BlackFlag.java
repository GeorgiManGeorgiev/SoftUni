package B_FM.MidExam.August;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double plunder = 0.0;
        for (int i = 1; i <= days; i++) {
            plunder += dailyPlunder;

            if (i % 3 == 0) {
                plunder += dailyPlunder * 0.5;
            }
            if (i % 5 == 0) {
                plunder *= 0.7;
            }
        }
        if (plunder>=expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", plunder);

        }else {
            double percentLeft = plunder/expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.",percentLeft);

        }
    }
}
