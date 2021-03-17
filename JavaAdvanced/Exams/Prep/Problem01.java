package C_JavaAdvanced.JavaAdv.Exams;

import java.util.*;
import java.util.stream.Collectors;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffect = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        int[] line = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        for (int num : line) {
            bombCasingStack.push(num);
        }

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        boolean isDone = false;

        while (!bombCasingStack.isEmpty() && !bombEffect.isEmpty() && !isDone) {
            int currBEffect = bombEffect.peek();
            int currBCasting = bombCasingStack.peek();
            int result = currBEffect + currBCasting;

            switch (result) {
                case 40:
                    bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                    bombEffect.remove();
                    bombCasingStack.pop();
                    break;
                case 60:
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                    bombEffect.remove();
                    bombCasingStack.pop();
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                    bombEffect.remove();
                    bombCasingStack.pop();
                    break;

                default:
                    bombCasingStack.pop();
                    bombCasingStack.push(currBCasting - 5);
                    break;

            }
            if (bombs.get("Datura Bombs") >= 3 &&
                    bombs.get("Cherry Bombs") >= 3 &&
                    bombs.get("Smoke Decoy Bombs") >= 3) {
                isDone = true;

            }
        }


        if (isDone){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffect.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {

            System.out.print("Bomb Effects: ");

            List<String> toPrint = bombEffect.stream().map(String::valueOf)
                    .collect(Collectors.toList());
            System.out.print(String.join(", ", toPrint).trim());
            System.out.println();
        }
        if (bombCasingStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {

            System.out.print("Bomb Casings: ");

            List<String> toPrint = bombCasingStack.stream().map(String::valueOf)
                    .collect(Collectors.toList());
            System.out.print(String.join(", ", toPrint).trim());
            System.out.println();
        }


        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.println(entry.getKey()+": "+ entry.getValue());
        }

    }
}
