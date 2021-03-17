package B_FM.Methods;

        import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printTopNums(n);

    }

    private static void printTopNums(int n) {

        for (int i = 1; i <= n; i++) {
            if (holdsOneOddDigit(i) && sumOfDigitsIsDivisibleBy8(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean holdsOneOddDigit(int n) {

        while (n != 0) {
            int newN = n % 10;
            if (newN % 2 == 1) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    private static boolean sumOfDigitsIsDivisibleBy8(int n) {
        int sum = 0;
        while (n != 0) {
            int newN = n % 10;
            sum += newN;
            n /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        }
        return false;
    }
}

