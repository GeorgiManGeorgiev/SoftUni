package C_JavaAdvanced.JavaAdv.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifferenceSecondVariant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        int primarySum = calcPrimarySum(matrix);
        int secondarySum = calcSecondarySum(matrix);
        System.out.println(Math.abs(primarySum - secondarySum));

    }

    private static int calcSecondarySum(int[][] matrix) {
        int sum = 0;
            int col = matrix[0].length-1;
            int row = 0;
        while(col>=0){
            sum+= matrix[row][col];
            col--;
            row++;
        }

        return sum;
    }

    private static int calcPrimarySum(int[][] matrix) {
       int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum+=matrix[i][i];
        }


        return sum;
    }

}
