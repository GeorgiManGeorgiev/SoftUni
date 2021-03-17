package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();

        int count = 0;
        String name = "";
        String mail = "";
        String line = scanner.nextLine();
        while (!"stop".equals(line)) {
            if (count % 2 == 0) {
                name = line;
            } else {
                mail = line;
                if (mailIsValid(mail)) {
                    map.put(name, mail);
                }
            }

            count++;
            line = scanner.nextLine();
        }
        map.entrySet()
                .forEach(entry -> {
                    System.out.printf("%s -> %s%n", entry.getKey()
                            , entry.getValue());
                });
    }

    private static boolean mailIsValid(String mail) {
        int startIndex = mail.indexOf('.');
        String sub = mail.substring(startIndex + 1);
        if (sub.equalsIgnoreCase("us")
                || sub.equalsIgnoreCase("com")
                || sub.equalsIgnoreCase("uk")) {
            return false;
        }
        return true;
    }
}
