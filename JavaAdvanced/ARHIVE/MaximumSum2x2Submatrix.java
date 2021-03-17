package C_JavaAdvanced.JavaAdv.ARHIVE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaximumSum2x2Submatrix { public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[][] matrix = fillMatrix(scanner);

    int bestSum = Integer.MIN_VALUE;
    int rowIndex = 0;
    int colIndex = 0;

    for (int row = 0; row < matrix.length - 1; row++) {
        for (int col = 0; col < matrix[row].length - 1; col++) {
            int sum = matrix[row][col] + matrix[row][col + 1]
                    + matrix[row + 1][col] + matrix[row + 1][col + 1];
            if (sum > bestSum) {
                bestSum = sum;
                rowIndex = row;
                colIndex = col;
            }
        }
    }
    System.out.println(matrix[rowIndex][colIndex] + " " + matrix[rowIndex][colIndex + 1]);
    System.out.println(matrix[rowIndex + 1][colIndex] + " " + matrix[rowIndex + 1][colIndex + 1]);
    System.out.println(bestSum);
}

    private static int[][] fillMatrix(Scanner scanner) {
        List<String> dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int rows = Integer.parseInt(dimensions.get(0));
        int cols = Integer.parseInt(dimensions.get(1));

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {

            String[] values = scanner.nextLine().split(", ");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(values[col]);

            }
        }
        return matrix;
    }

}
