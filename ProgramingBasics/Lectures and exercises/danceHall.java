package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class danceHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lengthOfHall = Double.parseDouble(scanner.nextLine());
        double widthOfHall = Double.parseDouble(scanner.nextLine());
        double sideOfWardrobe = Double.parseDouble(scanner.nextLine());
        double areaOfHall = (lengthOfHall * 100) * (widthOfHall * 100);
        double benchArea = areaOfHall / 10;
        double areaNeededByDancer = 40 + 7000;
        double areaOfWardrobe = Math.pow(sideOfWardrobe * 100, 2);
        double totalFreeArea = areaOfHall - benchArea - areaOfWardrobe;
        int dancersCount = (int) Math.floor(totalFreeArea / areaNeededByDancer);
        System.out.println(dancersCount);
    }
}
