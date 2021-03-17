package B_FM.RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            Pattern decryptionPattern = Pattern.compile("([starSTAR])");
            String input = scanner.nextLine();
            Matcher matcher = decryptionPattern.matcher(input);
            int decryptionKey = 0;
            while (matcher.find()) {
                decryptionKey++;
            }
            StringBuilder decryptedMessage = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                char curr = input.charAt(j);
                char charToAdd = (char) (curr - decryptionKey);
                decryptedMessage.append(charToAdd);
            }
            String decrypted = decryptedMessage.toString();


            String regex = "@(?<name>[A-Za-z]+)(?:[^@:!>\\-]*):(?<population>[\\d]+)(?:[^@:!>\\-]*)!(?<type>[AD])!(?:[^@:\\-!>]*)->(?<soldiers>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(decrypted);

            while (matcher.find()) {
                String type = matcher.group("type");
                if (type.equals("A")) {
                    attackedPlanets.add(matcher.group("name"));
                } else {
                    destroyedPlanets.add(matcher.group("name"));
                }
            }
        }

        System.out.println(String.format("Attacked planets: %d", attackedPlanets.size()));
        attackedPlanets.stream().sorted().forEach(e -> {
            System.out.println(String.format("-> %s", e));
        });

        System.out.println(String.format("Destroyed planets: %d", destroyedPlanets.size()));
        destroyedPlanets.stream().sorted().forEach(e -> {
            System.out.println(String.format("-> %s", e));
        });
    }
}
