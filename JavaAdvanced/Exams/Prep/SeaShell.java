package C_JavaAdvanced.JavaAdv.Exams.Prep;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SeaShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        String[][] beach = new String[n][];

        for (int i = 0; i < beach.length; i++) {
            beach[i] = scanner.nextLine().split("\\s+");
        }

        List<String> collectedShells = new LinkedList<>();
        int stolenShells = 0;
        String input = scanner.nextLine();

        while (!"Sunset".equals(input)) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int coll = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Collect":
                    if (isValidIndex(row, coll, beach)) {
                        String shell = beach[row][coll];
                        if (!shell.equals("-")) {
                            collectedShells.add(shell);
                            beach[row][coll] = "-";
                        }
                    }
                    break;
                case "Steal":
                    String direction = tokens[3];
                    if (isValidIndex(row, coll, beach)) {
                        String shell = beach[row][coll];
                        if (!shell.equals("-")) {
                            stolenShells++;
                            beach[row][coll] = "-";
                        }

                        stolenShells += stealing(beach, row, coll, direction);
                    }


                    break;


            }

            input = scanner.nextLine();
        }


        printStringMatrix(beach);
        System.out.print(String.format("Collected seashells: %d",collectedShells.size()));
        if (!collectedShells.isEmpty()){
            System.out.print(" -> ");
            System.out.println(String.join(", ",collectedShells));
        }else {
            System.out.println();
        }

        System.out.printf("Stolen seashells: %d",stolenShells);



    }

    private static int stealing(String[][] beach, int row, int coll, String direction) {

        int counter = 0;

        switch (direction) {
            case "up":
                for (int r = row; r >= row - 3; r--) {
                    if (isValidIndex(r, coll, beach)) {
                        String shell = beach[r][coll];
                        if (!shell.equals("-")) {
                            counter++;
                            beach[r][coll] = "-";
                        }
                    }
                }
                break;
            case "down":
                for (int r = row; r <= row + 3; r++) {
                    if (isValidIndex(r, coll, beach)) {
                        String shell = beach[r][coll];
                        if (!shell.equals("-")) {
                            counter++;
                            beach[r][coll] = "-";
                        }
                    }
                }

                break;
            case "left":
                for (int c = coll; c >= coll + 3; c--) {
                    if (isValidIndex(row, c, beach)) {
                        String shell = beach[row][c];
                        if (!shell.equals("-")) {
                            counter++;
                            beach[row][c] = "-";
                        }
                    }
                }

                break;
            case "right":
                for (int c = coll; c <= coll + 3; c++) {
                    if (isValidIndex(row, c, beach)) {
                        String shell = beach[row][c];
                        if (!shell.equals("-")) {
                            counter++;
                            beach[row][c] = "-";
                        }
                    }
                }

                break;
        }

        return counter;
    }

    private static boolean isValidIndex(int row, int coll, String[][] beach) {
        return row >= 0 && row < beach.length
                && coll >= 0 && coll < beach[row].length;
    }

    private static void printStringMatrix(String[][] beach) {
        for (int row = 0; row < beach.length; row++) {
            for (int coll = 0; coll < beach[row].length; coll++) {
                System.out.print(beach[row][coll] + " ");
            }
            System.out.println();
        }
    }
}
