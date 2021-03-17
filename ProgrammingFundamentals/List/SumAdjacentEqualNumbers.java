package B_FM.List;

        import java.text.DecimalFormat;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        int counter = 0;
        while (counter < numbers.size() - 1) {
            double currentNumber = numbers.get(counter);
            double nextNumber = numbers.get(counter + 1);
            if (currentNumber == nextNumber) {
                double sum = currentNumber + nextNumber;
                numbers.set(counter, sum);
                numbers.remove(counter + 1);
                counter = 0;
            } else {
                counter++;
            }
        }
        String output = joinElementsByDelimiter(numbers, " ");
        System.out.println(output);


    }

    public static String joinElementsByDelimiter(List<Double> items, String delimiter) {
        String output = "";
        for (Double item : items) {
            output += (new DecimalFormat("0.#").format(item) + delimiter);
        }
        return output;
    }
}
