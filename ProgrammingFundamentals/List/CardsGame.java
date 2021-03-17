package B_FM.List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = readIntegerToList(scanner);
        List<Integer> secondDeck = readIntegerToList(scanner);

        while (!(firstDeck.isEmpty() || secondDeck.isEmpty())) {

            if (firstDeck.get(0) > secondDeck.get(0)) {
                firstDeck.add(firstDeck.remove(0));
                firstDeck.add(secondDeck.remove(0));
               continue;
            }
            if (secondDeck.get(0) > firstDeck.get(0)) {
                secondDeck.add(secondDeck.remove(0));
                secondDeck.add(firstDeck.remove(0));
                continue;

            } if(firstDeck.get(0).equals(secondDeck.get(0))) {
                firstDeck.remove(0);
                secondDeck.remove(0);
                continue;
            }
        }
        int sum = 0;
        if (firstDeck.isEmpty()) {

            for (Integer integer : secondDeck) {
                sum += integer;
            }
            System.out.printf("EmojiDetector player wins! Sum: %d", sum);
        }else {

            for (Integer integer : firstDeck) {
                sum += integer;
            }
            System.out.printf("ActivationKeys player wins! Sum: %d", sum);
        }


    }

    public static List<Integer> readIntegerToList(Scanner scanner) {
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return integerList;
    }
}
