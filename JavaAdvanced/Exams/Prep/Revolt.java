package C_JavaAdvanced.JavaAdv.Exams.Prep;

import java.util.Scanner;

public class Revolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];

        int finishRow = 0;
        int finishCol = 0;

        int[] playerPositions = new int[2];


        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("f")) {
                playerPositions[0] = i;
                playerPositions[1] = line.indexOf("f");
            }
            if (line.contains("F")) {
                finishRow = i;
                finishCol = line.indexOf("F");
            }
            field[i] = line.toCharArray();
        }


        boolean hasWon = false;

        while (commandsCount-- > 0 && !hasWon) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    moveUp(field, playerPositions);
                    break;
                case "down":
                    moveDown(field, playerPositions);
                    break;
                case "left":
                    moveLeft(field, playerPositions);
                    break;
                case "right":
                    moveRight(field, playerPositions);
                    break;
            }

            hasWon = playerPositions[0] == finishRow && playerPositions[1] == finishCol;
        }

        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }


    }

    private static void moveUp(char[][] field, int[] playerPositions) {

        handleMovement(field, playerPositions, 0, -1);
    }
    private static void moveDown(char[][] field, int[] playerPositions) {

        handleMovement(field, playerPositions, 0, 1);
    }

    private static void moveLeft(char[][] field, int[] playerPositions) {

        handleMovement(field, playerPositions, 1, -1);
    }

    private static void moveRight(char[][] field, int[] playerPositions) {
        handleMovement(field, playerPositions, 1, 1);
    }
    public static void handleMovement(char[][] field, int[] playerPositions, int rowOrColIndex, int movementSpeed) {
        field[playerPositions[0]][playerPositions[1]] = '-';
        playerPositions[rowOrColIndex] += movementSpeed;

        handlePlayerOutOfBoundsMovement(field, playerPositions, rowOrColIndex, movementSpeed);


        if (field[playerPositions[0]][playerPositions[1]] == 'B') {
            playerPositions[rowOrColIndex] += movementSpeed;
        } else if (field[playerPositions[0]][playerPositions[1]] == 'T') {
            playerPositions[rowOrColIndex] -= movementSpeed;
        }

        handlePlayerOutOfBoundsMovement(field, playerPositions, rowOrColIndex, movementSpeed);

        field[playerPositions[0]][playerPositions[1]] = 'f';
    }

    private static void handlePlayerOutOfBoundsMovement(char[][] field, int[] playerPositions, int rowOrColIndex, int movementSpeed) {

        if (movementSpeed < 0) {
            if (playerPositions[rowOrColIndex] < 0) {
                playerPositions[rowOrColIndex] = field.length - 1;
            }
        } else {
            if (playerPositions[rowOrColIndex] >= field.length) {
                playerPositions[rowOrColIndex] = 0;
            }
        }
    }

}
