package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figureType = scanner.nextLine();
        if (figureType.equalsIgnoreCase("square")) {
            double side = Double.parseDouble(scanner.nextLine());
            double result = side * side;
            System.out.printf("%.3f", result);
        } else if (figureType.equalsIgnoreCase("rectangle")) {
            double sideA = Double.parseDouble(scanner.nextLine());
            double sideB = Double.parseDouble(scanner.nextLine());
            double result = sideA * sideB;
            System.out.printf("%.3f", result);
        } else if (figureType.equalsIgnoreCase("circle")) {
            double rad = Double.parseDouble(scanner.nextLine());
            double result = rad * rad * Math.PI;
            System.out.printf("%.3f", result);
        } else if (figureType.equalsIgnoreCase("triangle")) {
            double sideA = Double.parseDouble(scanner.nextLine());
            double sideB = Double.parseDouble(scanner.nextLine());
            double result = (sideA * sideB) / 2;
            System.out.printf("%.3f", result);
        }

    }
}
