package C_JavaAdvanced.JavaAdv.Exams.Prep;

import java.util.Scanner;

public class BookWorm {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        sb.append(scanner.nextLine().trim());
        int n = Integer.parseInt(scanner.nextLine());


        char[][] field = new char[n][n];

        int[] playerPositions = new int[2];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("P")) {
                playerPositions[0] = i;
                playerPositions[1] = line.indexOf("P");
            }

            field[i] = line.toCharArray();
        }


        String command;

        while (!"end".equals(command = scanner.nextLine())) {
            switch (command) {
                case "up":
                    movePlayer(field, playerPositions, 0, -1);
                    break;
                case "down":
                    movePlayer(field, playerPositions, 0, +1);
                    break;
                case "left":
                    movePlayer(field, playerPositions, 1, -1);
                    break;
                case "right":
                    movePlayer(field, playerPositions, 1, +1);
                    break;
            }
        }

        System.out.println(sb.toString().trim());
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }

    }

    private static void movePlayer(char[][] field, int[] playerPositions, int rowOrCol, int speed) {

        playerPositions[rowOrCol] += speed;
        if (isInBound(field, playerPositions[0], playerPositions[1])) {
            playerPositions[rowOrCol] -= speed;
            field[playerPositions[0]][playerPositions[1]] ='-';
            playerPositions[rowOrCol] += speed;
            if (field[playerPositions[0]][playerPositions[1]]!='-'){
                sb.append(field[playerPositions[0]][playerPositions[1]]);
                field[playerPositions[0]][playerPositions[1]]='P';
            }
        }else {
            playerPositions[rowOrCol] -= speed;
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private static boolean isInBound(char[][] field, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field.length;
    }
}
