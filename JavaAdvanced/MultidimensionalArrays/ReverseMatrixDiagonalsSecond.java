package C_JavaAdvanced.JavaAdv.MultidimensionalArrays;

import java.util.Scanner;

public class ReverseMatrixDiagonalsSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        String toPrint = "";
        int r = rows - 1;
        int c = cols - 1;

        for (int i = 1; i <= cols; i++) {

            while (r >= 0 && r <= rows - 1 && c >= 0 && c <= cols - 1) {
                toPrint =toPrint + matrix[r--][c++] + " ";

            }
            System.out.print(toPrint.trim());
            System.out.println();
            toPrint="";
            r = rows - 1;
            c = cols - 1 - i;
        }

        c = 0;
        r = rows - 2;
        for (int i = 1; i <= rows; i++) {

            while (r >= 0 && r <= rows - 1 && c >= 0 && c <= cols - 1) {
                toPrint = toPrint + matrix[r--][c++] + " ";
            }
            System.out.print(toPrint.trim());
            System.out.println();
            toPrint="";
            r = rows-2-i;
            c = 0;
        }
    }

}

