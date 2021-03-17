package person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();


        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":

                    birthables.add(
                            new Citizen(tokens[1],
                                    Integer.parseInt(tokens[2]),
                                    tokens[3],
                                    tokens[4]));
                    break;
                case "Robot":
                    new Robot(tokens[1],
                            tokens[2]);
                    break;
                case "Pet":
                    birthables.add(
                            new Pet(tokens[1],
                                    tokens[2]));
                    break;
            }

            line = scanner.nextLine();
        }
        String year = scanner.nextLine();

        boolean hasOutput = false;

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
                hasOutput = true;
            }
        }

        if (!hasOutput){
            System.out.println("<no output>");
        }
    }
}
