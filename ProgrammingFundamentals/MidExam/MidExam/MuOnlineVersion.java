package B_FM.MidExam.MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnlineVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int bitCoin = 0;

        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());




            for (int i = 0; i < rooms.size() ; i++) {
                String [] commands = rooms.get(i).split(" ");

                switch (commands[0]){
                    case "potion":
                        int healthToRestore = Integer.parseInt(commands[1]);
                        int healthAfterRestore = health + healthToRestore;
                        if (healthAfterRestore > 100) {
                            int healthOverHundred = healthAfterRestore - 100;
                            healthToRestore = healthToRestore - healthOverHundred;
                        }
                        System.out.printf("You healed for %d hp.%n", healthToRestore);
                        health+=healthToRestore;
                        System.out.printf("Current health: %d hp.%n", health);
                        break;
                    case "chest":
                        int bitCoinToAdd = Integer.parseInt(commands[1]);
                        bitCoin+=bitCoinToAdd;
                        System.out.printf("You found %d bitcoins.%n", bitCoin);
                        break;

                    default:


                        break;
                }








        }
    }
}
