package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class template {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String animal = scanner.nextLine();
        switch (animal) {
            case "dog":
                System.out.println("mammal");
                break;
            case "tortoise":
            case "snake":
            case "crocodile":
                System.out.println("reptile");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
