package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();


        fillNumbers(scanner, firstPlayer, secondPlayer);
        if (war(firstPlayer, secondPlayer)) return;
        printResult(firstPlayer,secondPlayer);

    }

    public static boolean war(Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                System.out.println(firstPlayer.isEmpty() ? "Second player win!" : "First player win!");
                return true;
            }

            int firstNum =  firstPlayer.iterator().next();
            firstPlayer.remove(firstNum);
            int secondNum =  secondPlayer.iterator().next();
            secondPlayer.remove(secondNum);

            if (firstNum>secondNum){
                firstPlayer.add(firstNum);
                firstPlayer.add(secondNum);
            }else if(secondNum>firstNum) {
            secondPlayer.add(firstNum);
            secondPlayer.add(secondNum);
            }
        }
        return false;
    }

    private static void printResult(Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
        if (firstPlayer.size()> secondPlayer.size()){
            System.out.println("First player win!");
        }else if (secondPlayer.size()>firstPlayer.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }

    public static void fillNumbers(Scanner scanner, Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
        String[] firstPlayerNumbers = scanner.nextLine().split(" ");
        String[] secondPlayerNumbers = scanner.nextLine().split(" ");

        for (String firstPlayerNumber : firstPlayerNumbers) {
            firstPlayer.add(Integer.parseInt(firstPlayerNumber));
        }

        for (String secondPlayerNumber : secondPlayerNumbers) {
            secondPlayer.add(Integer.parseInt(secondPlayerNumber));
        }
    }
}
