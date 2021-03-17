package C_JavaAdvanced.JavaAdv.MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int startIndex = line.indexOf("(");
        int endIndex = line.indexOf(")");
        int deg = Integer.parseInt(line.substring(startIndex + 1, endIndex));
        int rotDeg = deg % 360;


        int maxLength = Integer.MIN_VALUE;
        String input = scanner.nextLine();

        List<String> text = new ArrayList<>();
        while (!"END".equals(input)) {
            text.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scanner.nextLine();
        }
        char[][] matrix = writeMatrix(maxLength, text);
        switch (rotDeg) {
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                matrix = rotateMatrixBy90Degree(matrix);
                printMatrix(matrix);
                break;
            case 180:
                matrix = rotateMatrixBy90Degree(matrix);
                matrix = rotateMatrixBy90Degree(matrix);
                printMatrix(matrix);
                break;
            case 270:
                matrix = rotateMatrixBy90Degree(matrix);
                matrix = rotateMatrixBy90Degree(matrix);
                matrix = rotateMatrixBy90Degree(matrix);
                printMatrix(matrix);
                break;
        }
    }

    public static char[][] writeMatrix(int maxLength, List<String> text) {
        char[][] matrix = new char[text.size()][maxLength];

        for (int r = 0; r < matrix.length; r++) {
            String curr = text.get(r);
            if (text.get(r).length() < maxLength){
                int diff =  maxLength - text.get(r).length();
                for (int i = 0; i < diff ; i++) {
                    curr+= " ";
                }
            }
            char[] arr = curr.toCharArray();
            matrix[r] = arr;
        }
        return matrix;
    }
    private static char[][] rotateMatrixBy90Degree(char[][] matrix) {

        int rows = matrix[0].length;
        int cols = matrix.length;

        char[][] rotatedMatrix = new char[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotatedMatrix[j][(cols - 1) - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

}
