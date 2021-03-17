package C_JavaAdvanced.JavaAdv.DefiningClasses.CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Cat> cats = new HashMap<>();

        String line;
        while (!"End".equals(line= scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            String name = tokens[1];
            double specialParam = Double.parseDouble(tokens[2]);

            Cat cat;
            if (line.contains("Siamese")) {
                 cat = new Siamese(name, specialParam);
            } else if (line.contains("Cymric")) {
                 cat = new Cymric(name, specialParam);
            } else {
                 cat = new StreetExtraordinaire(name, specialParam);
            }
            cats.put(name,cat);

        }
          String name = scanner.nextLine();


        System.out.println(cats.get(name).toString());
    }
}
