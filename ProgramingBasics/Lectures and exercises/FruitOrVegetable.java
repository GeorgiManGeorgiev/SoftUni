package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class FruitOrVegetable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("banana") || s.equals("apple") || s.equals("kiwi") || s.equals("cherry") || s.equals("lemon") || s.equals("grapes")) {
            System.out.println("fruit");
        } else if (s.equals("tomato") || s.equals("cucumber") || s.equals("pepper") || s.equals("carrot")){
            System.out.println("vegetable");
        } else
            System.out.println("unknown");
        }
    }

