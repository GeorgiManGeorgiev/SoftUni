package A_PB.pastLectures.forCycle;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double evenSum = 0;
        double oddSum = 0;
        double evenMin = 1000000000.0;
        double evenMax = -1000000000.0;
        double oddMin = 1000000000.0;
        double oddMax = -1000000000.0;
        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += number;
                if (number > evenMax) {
                    evenMax = number;
                }
                if (number < evenMin) {
                    evenMin = number;
                }
            } else {
                oddSum += number;
                if (number > oddMax) {
                    oddMax = number;
                }
                if (number < oddMin) {
                    oddMin = number;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n",oddSum);
        if (oddMin == 1000000000.0){
            System.out.printf("OddMin=No,%n");

        }else {
            System.out.printf("OddMin=%.2f,%n",oddMin);
        }
        if (oddMax == -1000000000.0){
            System.out.printf("OddMax=No,%n");
        }else {
            System.out.printf("OddMax=%.2f,%n",oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n",evenSum);
        if (evenMin == 1000000000.0){
            System.out.printf("EvenMin=No,%n");

        }else {
            System.out.printf("EvenMin=%.2f,%n",evenMin);
        }
        if (evenMax == -1000000000.0){
            System.out.printf("EvenMax=No%n");
        }else {
            System.out.printf("EvenMax=%.2f%n",evenMax);
        }
    }
}
