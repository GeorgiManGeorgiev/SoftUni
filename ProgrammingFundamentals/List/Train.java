package B_FM.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Integer> wagons = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            wagons.add(Integer.parseInt(input[i]));
        }
        int capacity = Integer.parseInt(scanner.nextLine());

        String line;
        while (!"end".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(" ");
            if (tokens[0].equals("Add")) {
                int passengers = Integer.parseInt(tokens[1]);
                wagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(tokens[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int futurePassengers = wagons.get(i) + passengers;
                    if (futurePassengers <= capacity) {
                        wagons.set(i, futurePassengers);
                        break;
                    }
                }
            }
        }

        printList(wagons);
    }

    private static void printList(List<Integer> wagons) {
        for (int i = 0; i < wagons.size(); i++) {
            System.out.print(wagons.get(i) + " ");
        }
    }
}
