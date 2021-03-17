package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int freeSpace = width * length * height;

        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            int box = Integer.parseInt(input);
            freeSpace -= box;

            if (freeSpace < 0) {
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("Done")) {
            System.out.printf("%d Cubic meters left.", freeSpace);
        }else{
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(freeSpace));
        }
    }
}

