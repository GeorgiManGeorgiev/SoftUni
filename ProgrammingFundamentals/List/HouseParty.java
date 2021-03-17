package B_FM.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guestsCount = Integer.parseInt(scanner.nextLine());

        List<String> guestList = new ArrayList<>();

        for (int i = 1; i <= guestsCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input[2].equals("not")) {
                if (guestList.contains(input[0])){
                    guestList.remove(input[0]);
                }else{
                    System.out.printf("%s is not in the list!%n",input[0]);
                }

            } else {
                if (!guestList.contains(input[0])) {
                    guestList.add(input[0]);
                }else{
                    System.out.printf("%s is already in the list!%n",input[0]);
                }
            }
        }

        for (int i = 0; i <guestList.size() ; i++) {
            System.out.println(guestList.get(i));
        }

    }
}
