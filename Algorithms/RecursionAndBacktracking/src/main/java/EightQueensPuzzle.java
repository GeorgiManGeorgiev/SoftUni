import java.util.Scanner;

public class EightQueensPuzzle {
    public static char[][] board = {
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',}
    };
    public static  boolean[][] attackedPositions(int row){

        return attackedPositions[row][col]
    }

    public static void main(String[] args) {


            findQueenPositions(0);



    }

    private static void findQueenPositions(int row) {
        if (row == 8){
            printSolution();
        }else {

            for (int col = 0; col < 7; col++) {
                if (canPlaceQueen(row,col)){


                }
            }
        }

    }

    private static boolean canPlaceQueen(int row, int col) {
            return false;
    }


    public static void printSolution() {

        for (char[] chars : board) {
            for (char symbol : chars) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }


}
