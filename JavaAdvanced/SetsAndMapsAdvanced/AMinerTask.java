package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        int count = 0;
        String curr = "";
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!"stop".equals(input = scanner.nextLine().trim())) {

            if (count % 2 == 0) {
                curr = input;
                resources.putIfAbsent(input, 0);

            } else {
                resources.put(curr, resources.get(curr) + Integer.parseInt(input));


            }
            count++;

        }
        resources.entrySet().forEach(e -> {
            System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
        });
    }
}
