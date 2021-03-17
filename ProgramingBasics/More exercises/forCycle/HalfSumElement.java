package A_PB.pastLectures.forCycle;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            if (number > maxNum) {
                maxNum = number;
            }
        }
        int sumWithOutMaxNumber = sum-maxNum;
        if (sumWithOutMaxNumber == maxNum){
            System.out.printf("Yes%nSum = %d",maxNum);
        }else {
           int diff = Math.abs(maxNum- sumWithOutMaxNumber);
            System.out.printf("No%nDiff = %d",diff);
        }
    }
}
