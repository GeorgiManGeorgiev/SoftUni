package C_JavaAdvanced.JavaAdv.Exams.Prep;

import java.util.*;
import java.util.stream.Collectors;

public class Lootbox01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        ArrayDeque<Integer> firstStackBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        List<Integer> claimedItems = new LinkedList<>();

        while (!firstStackBox.isEmpty() && !secondBox.isEmpty()) {

            int sum = firstStackBox.peek() + secondBox.peekLast();
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstStackBox.removeFirst();
                secondBox.removeLast();
            } else {
                firstStackBox.offer(secondBox.pollLast());
            }
        }

        if (firstStackBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int claimedSum=0;
        for (Integer item : claimedItems) {
            claimedSum+=item;
        }
        if (100 <= claimedSum){
            System.out.printf("Your loot was epic! Value: %d%n",claimedSum);
        }else {
            System.out.printf("Your loot was poor... Value: %d%n",claimedSum);
        }

    }
}
