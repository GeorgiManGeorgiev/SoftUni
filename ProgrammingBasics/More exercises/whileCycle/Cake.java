package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int cakesCount = width * length;
        int cakesTaken = 0;
        String input = scanner.nextLine();
        while (cakesCount > 0){
            if (input.equals("STOP")){
                System.out.printf("%d pieces are left.", cakesCount);
                break;
            }
            cakesTaken = Integer.parseInt(input);
            cakesCount -= cakesTaken;
            if (cakesCount > 0) {
                input = scanner.nextLine();
            }

        }if (cakesCount<=0){
            int cakesCountAbs = Math.abs(cakesCount);
            System.out.printf("No more cake left! You need %d pieces more.",cakesCountAbs);
        }
    }
}
