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

    public static void main(String[] args) {


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
