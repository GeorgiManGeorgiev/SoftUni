package B_FM.MidExam.April;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> gifts = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("No Money")) {

            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "OutOfStock":
                    String giftOutOfStock = commands[1];
                    int index = gifts.indexOf(giftOutOfStock);
                    while (index >= 0) {
                        gifts.remove(index);
                        gifts.add(index, "None");
                        index = gifts.indexOf(giftOutOfStock);
                    }
                    break;
                case "Required":
                    String giftRequired = commands[1];
                    int indexOfReqGift = Integer.parseInt(commands[2]);
                    if (indexOfReqGift >= 0 && indexOfReqGift < gifts.size()) {
                        gifts.remove(indexOfReqGift);
                        gifts.add(indexOfReqGift, giftRequired);
                    }
                    break;
                case "JustInCase":
                    String giftToAdd = commands[1];
                    int indexOfLastGift = gifts.size() - 1;
                    gifts.remove(indexOfLastGift);
                    gifts.add(giftToAdd);
                    break;
            }


            input = scanner.nextLine();
        }


        for (String gift :
                gifts) {
            if (!gift.equals("None")) {
                System.out.print(gift + " ");
            }
        }
    }
}
