package C_JavaAdvanced.JavaAdv.Exams.Prep;

import java.util.*;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        Character[][] field = new Character[rows][];

        for (int i = 0; i < rows; i++) {
            field[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(str -> str.charAt(0))
                    .toArray(Character[]::new);

        }


        Map<String, Integer> harvest = new LinkedHashMap<>();
        harvest.put("Carrots", 0);
        harvest.put("Potatoes", 0);
        harvest.put("Lettuce", 0);

        int harmed = 0;


        String input = scanner.nextLine();

        while (!input.endsWith("End of Harvest")) {
            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("Harvest")) {
                harvestM(field, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), harvest);

            } else {
                harmed += mole(field, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);


            }

            input = scanner.nextLine();
        }

        printField(field);

        for (Map.Entry<String, Integer> entry : harvest.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Harmed vegetables: " + harmed);


    }

    private static int mole(Character[][] field, int row, int coll, String direction) {
        if (isOutOfBound(field, row, coll)) {
            return 0;
        }
        int harmed = 0;
        String veges = "LCP";
        if (direction.equals("up")) {
            for (int r = row; r >= 0; r -= 2) {
                if (isInBound(field, r, coll)) {
                    if (veges.contains("" + field[r][coll])) {
                        field[r][coll]= ' ';
                        harmed++;
                    }
                }
            }

        } else if (direction.equals("down")) {
            for (int r = row; r < field.length; r += 2) {
                if (isInBound(field, r, coll)) {
                    if (veges.contains("" + field[r][coll])) {
                        field[r][coll]= ' ';
                        harmed++;
                    }
                }
            }

        } else if (direction.equals("left")) {
            for (int c = coll; c >=0; c -= 2) {
                if (isInBound(field, row, c)) {
                    if (veges.contains("" + field[row][c])) {
                        field[row][c]= ' ';
                        harmed++;
                    }
                }
            }

        } else if (direction.equals("right")) {
            for (int c = coll; c < field[row].length; c += 2) {
                if (isInBound(field, row, c)) {
                    if (veges.contains("" + field[row][c])) {
                        field[row][c]= ' ';
                        harmed++;
                    }
                }
            }

        }
        return harmed;

    }

    private static boolean isInBound(Character[][] field, int r, int coll) {
        return !isOutOfBound(field, r, coll);

    }

    private static void printField(Character[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int coll = 0; coll < field[row].length; coll++) {
                System.out.print(field[row][coll] + " ");
            }
            System.out.println();
        }

    }

    private static void harvestM(Character[][] field, int row, int coll, Map<String, Integer> harvest) {
        if (isOutOfBound(field, row, coll)) {
            return;
        }
        if (field[row][coll] == 'L') {
            field[row][coll] = ' ';
            harvest.put("Lettuce", harvest.get("Lettuce") + 1);
        } else if (field[row][coll] == 'P') {
            field[row][coll] = ' ';
            harvest.put("Potatoes", harvest.get("Potatoes") + 1);
        } else if (field[row][coll] == 'C') {
            field[row][coll] = ' ';
            harvest.put("Carrots", harvest.get("Carrots") + 1);
        }
    }

    private static boolean isOutOfBound(Character[][] field, int row, int coll) {
        return row < 0 || row >= field.length
                || coll < 0 || coll >= field[row].length;

    }


}
