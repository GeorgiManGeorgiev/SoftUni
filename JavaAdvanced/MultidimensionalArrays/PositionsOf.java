package C_JavaAdvanced.JavaAdv.MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int number = scanner.nextInt();

        Deque<String> answers = new ArrayDeque<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (number == matrix[row][col]) {
                    String matchingPair = row + " " + col;
                    answers.offer(matchingPair);

                }
            }
        }
        if (answers.isEmpty()){
            System.out.println("not found");
        }else {
            while (!answers.isEmpty()){
                System.out.println(answers.poll());
            }
        }

    }

    private static void printIntMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        String line = scanner.nextLine();
        String[] split = line.split("\\s+");
        int rows = Integer.parseInt(split[0]);
        int cols = Integer.parseInt(split[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }
}
