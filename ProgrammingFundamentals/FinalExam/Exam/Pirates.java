package B_FM.FinalExam.Exam;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Long>> targets = new HashMap<>();

        String input = "";
        while (!"Sail".equals(input = scanner.nextLine())) {
            String[] citiesAndPopAndGold = input.split("[|]{2}");
            String city = citiesAndPopAndGold[0];
            int pop = Integer.parseInt(citiesAndPopAndGold[1]);
            int gold = Integer.parseInt(citiesAndPopAndGold[2].trim());
            if (!targets.containsKey(city)) {
                List<Long> toAdd = new ArrayList<>();
                toAdd.add(0, (long) pop);
                toAdd.add(1, (long) gold);
                targets.put(city, toAdd);
            } else {
                List<Long> toAdd = targets.get(city);
                Long populationOldValue = toAdd.remove(0);
                Long goldOldValue = toAdd.remove(0);
                Long populationToAdd = populationOldValue + pop;
                Long goldToAdd = goldOldValue + gold;
                toAdd.add(0, populationToAdd);
                toAdd.add(1, goldToAdd);
                targets.put(city, toAdd);
            }
        }


        while (!"End".equals(input = scanner.nextLine())) {
            String[] events = input.split("=>");
            String town = events[1];

            switch (events[0]) {
                case "Plunder":
                    long people = Long.parseLong(events[2].trim());
                    long gold = Long.parseLong(events[3].trim());
                    if (targets.containsKey(town)) {
                        System.out.println(String.format("%s plundered! %d gold stolen, %d citizens killed.", town, gold, people));
                        List<Long> citiesAndPopAndGold = targets.get(town);
                        long oldPop = citiesAndPopAndGold.remove(0);
                        long oldGold = citiesAndPopAndGold.remove(0);
                        long newPop = oldPop - people;
                        long newGold = oldGold - gold;
                        if (newPop <= 0 || newGold <= 0) {
                            targets.remove(town);
                            System.out.println(String.format("%s has been wiped off the map!", town));
                        } else {
                            citiesAndPopAndGold.add(0, newPop);
                            citiesAndPopAndGold.add(1, newGold);
                        }
                    }
                    break;
                case "Prosper":
                    gold = Long.parseLong(events[2]);
                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    } else {
                        List<Long> citiesAndPopAndGold = targets.get(town);
                        long oldGold = citiesAndPopAndGold.remove(1);
                        long newGold = oldGold + gold;
                        citiesAndPopAndGold.add(1, newGold);
                        System.out.println(String.format("%d gold added to the city treasury. %s now has %d gold.", gold, town, newGold));
                    }
                    break;
            }
        }
        if (!targets.isEmpty()) {
            System.out.println(String.format("Ahoy, Captain! There are %d wealthy settlements to go to:", targets.size()));

            targets
                    .entrySet()
                    .stream()
                    .sorted((u1, u2) -> {
                        int result = (int) (u2.getValue().get(1) - u1.getValue().get(1));
                        if (result == 0) {
                            result = u1.getKey().compareTo(u2.getKey());

                        }
                        return result;
                    })
                    .forEach(u -> {
                        System.out.println(String.format("%s -> Population: %d citizens, Gold: %d kg",u.getKey(),u.getValue().get(0),u.getValue().get(1)));

                    });
        }else{
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
