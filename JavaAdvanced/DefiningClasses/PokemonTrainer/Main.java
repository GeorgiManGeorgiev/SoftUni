package C_JavaAdvanced.JavaAdv.DefiningClasses.PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!"Tournament".equals(line)) {
            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String name = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Trainer trainer = new Trainer(trainerName);


            Pokemon pokemon = new Pokemon(name, element, health);

            trainers.putIfAbsent(trainerName, trainer);

            trainers.get(trainerName).addPokemon(pokemon);


            line = scanner.nextLine();
        }
        line = scanner.nextLine();

        while (!"End".equals(line)) {
            String element = line;

            for (Trainer trainer : trainers.values()) {
               if (trainer.hasElementType(element)){
                    trainer.incrementBadges(1);

               }else {
                   trainer.damagePokemons(10);

               }
            }

            line = scanner.nextLine();
        }
        trainers
                .entrySet()
                .stream()
                .sorted((f,s)-> s.getValue().getBadges() - f.getValue().getBadges())
                .forEach(entry->{
                    System.out.println(entry.getValue().toString());
                });
    }
}
