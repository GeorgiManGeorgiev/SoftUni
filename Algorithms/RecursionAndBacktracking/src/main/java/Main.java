import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//01 calculateFactorial

//        long result = calculateFactorial(5);
//        System.out.println(result);


// 02
//        recursiveDrawing(5);


// 03 generateBitVector
//        Integer[] memory = new Integer[6];
//        generateBitVector(memory, 0);


// 04 backtracking
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] labyrinth = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            labyrinth[row] = scanner.nextLine().toCharArray();
        }

        findPath(labyrinth, 0, 0);

    }


    private static void findPath(char[][] labyrinth, int row, int col) {

        if (!isInBounds(labyrinth, row, col)) {
            return;

        }
        labyrinth[row][col] = 'V';

        findPath(labyrinth,row,col);
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length && row >= 0 && col < labyrinth[row].length && col >= 0;
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