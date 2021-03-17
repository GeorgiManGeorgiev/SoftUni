package B_FM.MidExam.March;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class seizeFire {
    static boolean isFireValid(String type, int value) {
        switch (type) {
            case "High":
                return 81 <= value && value <= 125;

            case "Medium":
                return 51 <= value && value <= 80;

            case "Low":
                return 1 <= value && value <= 50;

            default:
                return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cells = scanner.nextLine().split("#");
        int water = scanner.nextInt();
        double effort = 0;
        int totalFirePutOut = 0;
        List<Integer> firesPutOut = new ArrayList<>();

        for (String cell :
                cells) {
            String[] typeAndValue = cell.split(" = ");
            String type = typeAndValue[0];
            int value = Integer.parseInt(typeAndValue[1]);


            if (isFireValid(type, value) && water >= value) {
                water -= value;
                firesPutOut.add(value);
                totalFirePutOut += value;
                effort += value * 0.25;
            }
        }


        System.out.println("Cells:");
        for (int fire : firesPutOut
        ) {
            System.out.println(" - " + fire);
        }

        System.out.printf("Effort: %.2f%n", effort);
        System.out.printf("Total Fire: %d", totalFirePutOut);
    }
}
