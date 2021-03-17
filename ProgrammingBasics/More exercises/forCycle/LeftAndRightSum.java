package A_PB.pastLectures.forCycle;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sumNum = 0;
        int sumNum1 = 0;
        for (int i = 0; i < n ; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sumNum += num;

        }
        for (int i = 0; i < n ; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            sumNum1 += num1;
        }
        if(sumNum == sumNum1){
            System.out.printf("Yes, sum = %d",sumNum);
        }else {
            System.out.printf("No, diff = %d",(Math.abs(sumNum-sumNum1)));
        }
    }
}
