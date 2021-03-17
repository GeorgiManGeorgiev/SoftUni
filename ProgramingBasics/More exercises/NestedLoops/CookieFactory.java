package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class CookieFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int batchesCount = Integer.parseInt(scanner.nextLine());
        for (int batch = 1; batch <= batchesCount; batch++) {
            boolean hasFlour = false;
            boolean hasSugar = false;
            boolean hasEggs = false;
            boolean isBatchReady = false;
            while (!isBatchReady) {
                String input = scanner.nextLine();
                if (input.equals("flour")) {
                    hasFlour = true;
                } else if (input.equals("sugar")) {
                    hasSugar = true;
                } else if (input.equals("eggs")) {
                    hasEggs = true;
                } else if (input.equals("Bake!")) {
                    if (hasFlour && hasEggs && hasSugar) {
                        isBatchReady = true;
                        System.out.printf("Baking batch number %d...%n", batch);
                    } else {
                        System.out.printf("The batter should contain flour, eggs and sugar!%n");
                    }
                }
            }
        }

    }

}

