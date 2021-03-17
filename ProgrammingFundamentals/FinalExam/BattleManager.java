package B_FM.FinalExam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BattleManager {
    static Map<String, Integer> peopleHealth = new HashMap<>();
    static Map<String, Integer> peopleEnergy = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = "";
        while (!"Results".equals(command = scanner.nextLine())) {

            String[] commandParts = command.split(":");
            String commandType = commandParts[0];
            switch (commandType) {
                case "Add":
                    add(commandParts[1], Integer.parseInt(commandParts[2]), Integer.parseInt(commandParts[3]));
                    break;
                case "Attack":
                    attack(commandParts[1], commandParts[2], Integer.parseInt(commandParts[3]));
                    break;
                case "Delete":
                    delete(commandParts[1]);
                    break;
                default:
                    throw new IllegalStateException("Unknown command" + command + "of type" + commandType);
            }
        }

        List<String> names = peopleHealth.entrySet().stream()
                .sorted((entryA, entryB) -> {
                    int healthA = entryA.getValue();
                    String nameA = entryA.getKey();
                    int healthB = entryB.getValue();
                    String nameB = entryB.getKey();

                    if (healthA != healthB) {
                        return Integer.compare(healthB, healthA);
                    } else {
                        return nameA.compareTo(nameB);
                    }
                })
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());


        System.out.printf("People count: %d%n", names.size());
        for (String name : names) {
            System.out.printf("%s - %d - %d%n", name, peopleHealth.get(name), peopleEnergy.get(name));
        }
    }

    private static void delete(String id) {
        if (id.equals("All")) {
            peopleHealth.clear();
            peopleEnergy.clear();
        } else {
            disqualify(id, false);
        }
    }

    private static void attack(String attacker, String defender, int damage) {
        Integer defenderHealth = peopleHealth.get(defender);
        Integer attackerEnergy = peopleEnergy.get(attacker);
        if (defenderHealth != null && attackerEnergy != null) {
            defenderHealth -= damage;
            if (defenderHealth <= 0) {
                disqualify(defender, true);
            } else {
                peopleHealth.put(defender, defenderHealth);
            }
            attackerEnergy--;
            if (attackerEnergy == 0) {
                disqualify(attacker, true);
            } else {
                peopleEnergy.put(attacker, attackerEnergy);
            }
        }

    }

    private static void disqualify(String id, boolean showMessage) {
        peopleHealth.remove(id);
        peopleEnergy.remove(id);
        if (showMessage) {
            System.out.printf("%s was disqualified!%n", id);
        }
    }

    private static void add(String name, int health, int energy) {
        Integer currentHealth = peopleHealth.get(name);
        if (currentHealth == null) {
            peopleHealth.put(name, health);
            peopleEnergy.put(name, energy);
        } else {
            peopleHealth.put(name, health + currentHealth);

        }
    }
}
