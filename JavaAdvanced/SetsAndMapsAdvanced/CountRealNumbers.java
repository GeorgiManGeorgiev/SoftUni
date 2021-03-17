package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();
        for (double num : arr) {
            if (!numbers.containsKey(num)) {
                numbers.put(num, 0);
            }
            numbers.put(num, numbers.get(num) + 1);
        }

        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(),entry.getValue());
        }
    }
}
