package C_JavaAdvanced.JavaAdv.MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());


        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }

        }
        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;
        int firstDiagonalRow = 0;
        int firstDiagonalCol = 0;
        int secondDiagonalRow = 0;
        int secondDiagonalCol = matrix.length - 1;
        while (true) {
            if (firstDiagonalRow >= matrix.length) {
                break;
            }
            firstDiagonalSum += matrix[firstDiagonalRow][firstDiagonalCol];
            secondDiagonalSum += matrix[secondDiagonalRow][secondDiagonalCol];
            firstDiagonalRow++;
            firstDiagonalCol++;
            secondDiagonalRow++;
            secondDiagonalCol--;
        }
        int result = Math.abs(firstDiagonalSum - secondDiagonalSum);
        System.out.println(result);
    }
}
