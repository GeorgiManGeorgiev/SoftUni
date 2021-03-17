package B_FM.MidExam.August;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShipSections = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warShipSection = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());


        String command = scanner.nextLine();
        while (!command.equals("Retire")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Fire":
                    int sectionIndex = Integer.parseInt(commandParts[1]);
                    int damage = Integer.parseInt(commandParts[2]);

                    if (!isValidIndex(warShipSection.size(), sectionIndex)) {
                        break;
                    }
                    Integer sectionHealth = warShipSection.get(sectionIndex);
                    sectionHealth -= damage;
                    if (sectionHealth <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                    warShipSection.set(sectionIndex, sectionHealth);
                    break;

                case "Defend":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    int damageDealt = Integer.parseInt(commandParts[3]);
                    if (!isValidIndex(pirateShipSections.size(), startIndex)) {
                        break;
                    }
                    if (!isValidIndex(pirateShipSections.size(), endIndex)) {
                        break;
                    }
                    for (int i = startIndex; i <= endIndex; i++) {
                        int health = pirateShipSections.get(i);
                        health -= damageDealt;
                        if (health <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                        pirateShipSections.set(i, health);
                    }
                    break;

                case "Repair":
                    int index = Integer.parseInt(commandParts[1]);
                    int repairHealth = Integer.parseInt(commandParts[2]);
                    if (!isValidIndex(pirateShipSections.size(), index)) {
                        break;
                    }
                    Integer section = pirateShipSections.get(index);
                    section += repairHealth;
                    if (section > maxHealth) {
                        section = maxHealth;
                    }
                    pirateShipSections.set(index, section);
                    break;


                case "Status":
                    int count = 0;
                    double threshold = maxHealth * 0.2;
                    for (Integer pirateSection :
                            pirateShipSections) {
                        if (pirateSection < threshold) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }

            command = scanner.nextLine();
        }

        int pirateSum = 0;
        for (Integer pirateShipSection : pirateShipSections) {
            pirateSum += pirateShipSection;
        }
        int warShipSum = 0;
        for (Integer integer : warShipSection) {
            warShipSum+=integer;
        }

        System.out.printf("Pirate ship status: %d%nWarship status: %d", pirateSum, warShipSum);

    }

    private static boolean isValidIndex(int size, int sectionIndex) {
        if (sectionIndex < 0 || sectionIndex >= size) {
            return false;
        }
        return true;
    }
}
