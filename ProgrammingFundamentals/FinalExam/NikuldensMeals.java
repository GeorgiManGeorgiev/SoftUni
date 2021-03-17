package B_FM.FinalExam;

import java.util.*;

public class NikuldensMeals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<String>> likedMeals = new HashMap<>();
        int unlikedMeals = 0;

        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String type = tokens[0];
            String guestName = tokens[1];
            String mealName = tokens[2];


            switch (type) {
                case "Like":
                    List<String> guestMeals = likedMeals.get(guestName);

                    if (guestMeals == null) {
                        guestMeals = new ArrayList<>();
                    }
                    if (!guestMeals.contains(mealName)) {
                        guestMeals.add(mealName);
                    }
                    likedMeals.put(guestName, guestMeals);
                    break;
                case "Unlike":
                    if (!likedMeals.containsKey(guestName)) {
                        System.out.println(String.format("%s is not at the party.", guestName));
                    } else {
                        List<String> meals = likedMeals.get(guestName);
                        if (!meals.contains(mealName)) {
                            System.out.println(String.format("%s doesn't have the %s in his/her collection.", guestName, mealName));
                        } else {
                            unlikedMeals++;
                            meals.remove(mealName);
                            System.out.printf("%s doesn't like the %s.%n", guestName, mealName);
                            likedMeals.put(guestName, meals);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        likedMeals
                .entrySet()
                .stream()
                .sorted((l, r) -> {
                    int compare = r.getValue().size() - l.getValue().size();
                    if (compare == 0) {
                        return l.getKey().compareTo(r.getKey());
                    } else {
                        return compare;
                    }
                })
                .forEach((e) -> System.out.println(e.getKey() + ": " + printList(e.getValue())));


        System.out.println(String.format("Unliked meals: %d", unlikedMeals));
    }

    private static String printList(List<String> value) {
        return value.toString().replaceAll("[\\[\\]]", "");
    }
}
