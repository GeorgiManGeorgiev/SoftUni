package C_JavaAdvanced.JavaAdv.MultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        String[][] matrix = new String[r][c];
        fillMatrix(matrix);
        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix) {
        char firstLetterAndLast;
        char middleLetter;
        String curr = "";
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                firstLetterAndLast = (char) (97 + r);
                middleLetter = (char) (97 + r + c);
                curr += firstLetterAndLast;
                curr += middleLetter;
                curr += firstLetterAndLast;
                matrix[r][c] = curr;
                curr = "";
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
