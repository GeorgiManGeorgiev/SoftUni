package B_FM.nextLectures.basic;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());


        int trashedHeadset = lostGamesCount / 2;
        int trashedMouse = lostGamesCount / 3;
        int trashedKeyboards = lostGamesCount / 6;
        int trashedDisplays = lostGamesCount / 12;

        double gamesCost =
                        trashedHeadset * headsetPrice +
                        trashedMouse * mousePrice +
                        trashedKeyboards * keyboardPrice +
                        trashedDisplays * displayPrice;

        System.out.println(String.format("Rage expenses: %.2f lv.", gamesCost));
    }
}
