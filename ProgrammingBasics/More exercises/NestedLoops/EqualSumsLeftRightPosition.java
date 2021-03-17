package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class EqualSumsLeftRightPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= secondNum; i++) {
            int firstTwoNumbers = i / 1000;
            int secondTwoNumbers = i % 100;
            int middleNumber = i % 1000 / 100;

            int firstFromFirst = firstTwoNumbers / 10;
            int secondFromFirst = firstTwoNumbers % 10;

            int firstFromSecond = secondTwoNumbers / 10;
            int secondFromSecond = secondTwoNumbers % 10;

            int firstSum = firstFromFirst + secondFromFirst;
            int secondSum = firstFromSecond + secondFromSecond;

            if (firstSum != secondSum) {
                if (firstSum < secondSum) {
                    firstSum += middleNumber;
                } else {
                    secondSum += middleNumber;
                }
            }
            if (firstSum == secondSum){
                System.out.print(i + " ");
            }
        }
    }
}
