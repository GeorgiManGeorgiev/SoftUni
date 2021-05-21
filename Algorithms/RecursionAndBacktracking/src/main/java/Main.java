import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


//01 calculateFactorial

//        long result = calculateFactorial(5);
//        System.out.println(result);


// 02
//        recursiveDrawing(5);


// 03 generateBitVector
//        Integer[] memory = new Integer[6];
//        generateBitVector(memory, 0);


    }

    private static long calculateFactorial(int n) {

        if (n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

    private static void recursiveDrawing(int n) {

        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();


        recursiveDrawing(n - 1);


        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
        System.out.println();

    }

    private static void generateBitVector(Integer[] memory, int index) {

        if (index >= memory.length) {
            for (Integer integer : memory) {
                System.out.print(integer);
            }

            System.out.println();
            return;
        }


        for (int i = 0; i <= 1; i++) {
            memory[index] = i;
            generateBitVector(memory, index + 1);
        }
    }

}
