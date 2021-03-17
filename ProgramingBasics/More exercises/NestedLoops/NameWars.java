package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class NameWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int maxSum = Integer.MIN_VALUE;
        String maxSumName = "";
        while (!name.equals("STOP")) {
            int lengthOfName = name.length();
            int nameSum = 0;
            for (int pos = 0; pos < lengthOfName; pos++) {
                char currentSymbol = name.charAt(pos);
                int asciiValue = (int) currentSymbol;
                nameSum += asciiValue;
            }
            if (nameSum > maxSum) {
                maxSum = nameSum;
                maxSumName = name;
            }
            name = scanner.nextLine();
        }
        System.out.printf("Winner is %s - %d!",maxSumName,maxSum);
    }
}
