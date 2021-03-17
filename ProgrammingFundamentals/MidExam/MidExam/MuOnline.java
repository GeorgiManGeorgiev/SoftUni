package B_FM.MidExam.MidExam;

        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        int health = 100;
        int totalBitCoins = 0;

        for (int i = 0; i < rooms.size(); i++) {
            String currRoom = rooms.get(i);
            String[] commands = currRoom.split("\\s+");

            if (commands[0].equals("potion")) {
                int healthToRestore = Integer.parseInt(commands[1]);
                int healthAfterRestore = health + healthToRestore;
                if (healthAfterRestore > 100) {
                    int healthOverHundred = healthAfterRestore - 100;
                    healthToRestore = healthToRestore - healthOverHundred;
                }
                System.out.printf("You healed for %d hp.%n", healthToRestore);
                health+=healthToRestore;
                System.out.printf("Current health: %d hp.%n", health);
                continue;
            }
            if (commands[0].equals("chest")) {
                int bitCoin = Integer.parseInt(commands[1]);
                totalBitCoins+=bitCoin;
                System.out.printf("You found %d bitcoins.%n", bitCoin);
                continue;

            }
            else  {
                String monster = commands[0];
                int monsterAttack = Integer.parseInt(commands[1]);
                health -=monsterAttack;
                if (health>0){
                    System.out.printf("You slayed %s.%n", monster);
                }if(health<=0){
                    System.out.printf("You died! Killed by %s.%n", monster);
                    System.out.printf("Best room: %d", i+1);
                    return;
                }
            }
        }
        System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d",totalBitCoins,health);

    }
}
