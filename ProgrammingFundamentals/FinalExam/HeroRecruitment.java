package B_FM.FinalExam;

import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<String>> heroes = new HashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "Enroll":
                    if (heroes.containsKey(heroName)) {
                        System.out.println(String.format("%s is already enrolled.", heroName));
                    } else {
                        heroes.put(heroName, new ArrayList<>());
                    }
                    break;

                case "Learn": {
                    String spellName = tokens[2];
                    ArrayList<String> spells = heroes.get(heroName);
                    if (heroes.containsKey(heroName)) {
                        if (heroes.get(heroName).contains(spellName)) {
                            System.out.println(String.format("%s has already learnt %s.", heroName, spellName));
                        } else {
                            spells.add(spellName);
                        }
                    } else {
                        System.out.println(String.format("%s doesn't exist.", heroName));

                    }
                }
                break;
                case "Unlearn":
                    String spellName = tokens[2];
                    if (heroes.containsKey(heroName)) {
                        ArrayList<String> spells = heroes.get(heroName);
                        if (spells.contains(spellName)) {
                            spells.remove(spellName);
                        } else {
                            System.out.println(String.format("%s doesn't know %s.", heroName, spellName));
                        }
                    } else {
                        System.out.println(String.format("%s doesn't exist.", heroName));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Heroes:");
        heroes
                .entrySet()
                .stream()
                .sorted((h1, h2) -> {
                    int result = Integer.compare(h2.getValue().size(), h1.getValue().size());
                    if (result == 0) {
                        result = h1.getKey().compareTo(h2.getKey());
                    }
                    return result;
                })
                .forEach(h -> {
                    System.out.print(String.format("== %s: ", h.getKey()));
                    System.out.println(String.join(", ", h.getValue()));
                });
    }
}


