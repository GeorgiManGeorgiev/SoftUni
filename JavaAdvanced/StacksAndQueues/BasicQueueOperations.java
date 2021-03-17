package C_JavaAdvanced.JavaAdv.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numToOffer = scanner.nextInt();
        int numToPoll = scanner.nextInt();
        int lookUpNum = scanner.nextInt();
        scanner.nextLine();

        Deque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numToOffer; i++) {
            numbers.offer(scanner.nextInt());
        }
        for (int i = 0; i < numToPoll; i++) {
            numbers.poll();
        }
        if (numbers.contains(lookUpNum)) {
            System.out.println("true");
        } else {
            System.out.println(numbers.stream()
                    .min(Integer::compareTo)
                    .orElse(0));
        }
    }
}
