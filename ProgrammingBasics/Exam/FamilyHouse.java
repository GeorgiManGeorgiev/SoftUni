package A_PB.Exam;

import java.util.Scanner;

public class FamilyHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mounts = Integer.parseInt(scanner.nextLine());

        double electricity = 0;
        double water = 0;
        double internet = 0;
        double other = 0;
        double average = 0;

        for (int i = 1; i <= mounts; i++) {
            double currentEl =Double.parseDouble(scanner.nextLine());
            electricity += currentEl;
            double currentWater = 20;
            water += currentWater;
            double currentInternet = 15;
            internet += currentInternet;

            double others1 = currentEl+currentWater+currentInternet;
            other += others1 + (others1 * 0.2);

        }

        average=(electricity+water+internet+other)/mounts;


        System.out.printf("Electricity: %.2f lv%n",electricity);
        System.out.printf("Water: %.2f lv%n",water);
        System.out.printf("Internet: %.2f lv%n",internet);
        System.out.printf("Other: %.2f lv%n",other);
        System.out.printf("Average: %.2f lv",average);

    }
}
