package B_FM.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> resultNums = new ArrayList<>();
        for (int i = 0; i < Math.min(numbers1.size(), numbers2.size()); i++) {
            resultNums.add(numbers1.get(i));
            resultNums.add(numbers2.get(i));
        }
        if (numbers1.size() > numbers2.size()) {
            resultNums.addAll(getRemainingElements(numbers1, numbers2));

        } else if (numbers2.size() > numbers1.size()) {
            resultNums.addAll(getRemainingElements(numbers2, numbers1));
        }

        System.out.println(resultNums.toString().replaceAll("[\\[\\],]", ""));
    }

    public static List<Integer> getRemainingElements(List<Integer> longer, List<Integer> shorter) {
        List<Integer> nums = new ArrayList<>();
        for (int i = shorter.size(); i < longer.size(); i++) {
            nums.add(longer.get(i));
        }
        return nums;
    }
}
