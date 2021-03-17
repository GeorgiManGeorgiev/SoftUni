package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class squareArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String squareSideString = scanner.nextLine();
        int squareSide = Integer.parseInt(squareSideString);
        int squareArea = squareSide * squareSide;
        System.out.println(squareArea);


    }
}
