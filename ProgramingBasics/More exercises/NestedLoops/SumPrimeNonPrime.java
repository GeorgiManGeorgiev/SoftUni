package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumPrime = 0;
        int sumNonPrime = 0;
        String input = scanner.nextLine();
        int currentNumber;
        while (!input.equalsIgnoreCase("stop")) {
            currentNumber = Integer.parseInt(input);
            if (currentNumber >= 0) {
                boolean isPrimeNumber = true;
                for (int i = 2; i < currentNumber; i++) {
                    if (currentNumber % i == 0) {
                        isPrimeNumber = false;
                        break;
                    }
                }
                 if (isPrimeNumber){
                     sumPrime += currentNumber;
                 }else{
                     sumNonPrime += currentNumber;
                 }
            } else {
                System.out.printf("Number is negative.%n");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%nSum of all non prime numbers is: %d",sumPrime,sumNonPrime);
    }
}
