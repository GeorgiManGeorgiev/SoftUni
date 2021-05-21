import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


//calculateFactorial
//        long result = calculateFactorial(5);
//        System.out.println(result);


    }

    private static long calculateFactorial(int n) {

        if (n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }



}
