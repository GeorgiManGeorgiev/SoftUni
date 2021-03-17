package C_JavaAdvanced.JavaAdv.Exams;

import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];
        int[] snakePoss = new int[2];
        for (int r = 0; r < n; r++) {
            String line = scanner.nextLine();
            if (line.contains("S")) {
                snakePoss[0] = r;
                snakePoss[1] = line.indexOf("S");
            }
            field[r] = line.toCharArray();
        }

        int[] food = new int[1];
        food[0] = 0;
        boolean isSnakeOut = false;

        while (food[0] < 10 && !isSnakeOut) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (moveUp(field, snakePoss, food)) {
                        break;
                    } else {
                        isSnakeOut = true;
                    }
                    break;
                case "down":
                    if (moveDown(field, snakePoss, food)) {
                        break;
                    } else {
                        isSnakeOut = true;
                    }
                    break;
                case "left":
                    if (moveLeft(field, snakePoss, food)) {
                        break;
                    } else {
                        isSnakeOut = true;
                    }
                    break;
                case "right":
                    if (moveRight(field, snakePoss, food)) {
                        break;
                    } else {
                        isSnakeOut = true;
                    }
                    break;
            }

        }
            if (isSnakeOut){
                System.out.println("Game over!");
            }
            if (food[0]>=10){
                System.out.println("You won! You fed the snake.");
            }

            System.out.println("Food eaten: "+food[0]);
            printCharMatrix(field);


    }

    private static void printCharMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int coll = 0; coll <matrix[row].length ; coll++) {
                System.out.print(matrix[row][coll]);
            }
            System.out.println();

        }
    }

    private static boolean moveUp(char[][] field, int[] snakePoss, int[] food) {

        return moveSnake(field, snakePoss, 0, -1, food);
    }

    private static boolean moveDown(char[][] field, int[] snakePoss, int[] food) {

        return  moveSnake(field, snakePoss, 0, 1, food);
    }

    private static boolean moveLeft(char[][] field, int[] snakePoss, int[] food) {

        return moveSnake(field, snakePoss, 1, -1, food);
    }

    private static boolean moveRight(char[][] field, int[] snakePoss, int[] food) {
      return   moveSnake(field, snakePoss, 1, 1, food);
    }

    public static boolean moveSnake(char[][] field, int[] snakePoss, int rowOrColIndex, int movementSpeed, int[] food) {

        field[snakePoss[0]][snakePoss[1]] = '.';
        snakePoss[rowOrColIndex] += movementSpeed;
        if (!isValidIndex(snakePoss[0], snakePoss[1], field)) {
            return false;
        }
        if (field[snakePoss[0]][snakePoss[1]] == 'B') {
            field[snakePoss[0]][snakePoss[1]] = '.';

            for (int r = 0; r < field.length; r++) {
                for (int c = 0; c < field[r].length; c++) {
                    if (field[r][c] == 'B') {
                        snakePoss[0] = r;
                        snakePoss[1] = c;
                        field[r][c] ='.';
                    }
                }
            }
        }
        if (field[snakePoss[0]][snakePoss[1]] == '*') {
            food[0] += 1;
        }

        field[snakePoss[0]][snakePoss[1]] = 'S';
        return true;
    }

    private static boolean isValidIndex(int row, int coll, char[][] field) {
        return row >= 0 && row < field.length
                && coll >= 0 && coll < field[row].length;
    }
}
