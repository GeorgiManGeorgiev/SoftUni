package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flowerType = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        // Roses Dahlias Tulips Narcissus Gladiolus 
        // Hey, you have a great garden with  and  leva left.
        // Not enough money, you need leva more.
        double price = 0;
        double rosesPrice = 5;
        double dahliasPrice = 3.80;
        double tulipsPrice = 2.80;
        double narcissusPrice = 3;
        double gladiolusPrice = 2.50;
        switch (flowerType) {
            case "Roses":
                price = flowersCount * rosesPrice;
                break;
            case "Dahlias":
                price = flowersCount * dahliasPrice;
                break;
            case "Tulips":
                price = flowersCount * tulipsPrice;
                break;
            case "Narcissus":
                price = flowersCount * narcissusPrice;
                break;
            case "Gladiolus":
                price = flowersCount * gladiolusPrice;
                break;

        }
        if (flowersCount > 80 && flowerType.equals("Roses")) {
            price -= price * 0.1;
        } else if (flowersCount > 90 && flowerType.equals("Dahlias")) {
            price -= price * 0.15;
        } else if (flowersCount > 80 && flowerType.equals("Tulips")) {
            price -= price * 0.15;
        } else if (flowersCount < 120 && flowerType.equals("Narcissus")) {
            price += price * 0.15;
        } else if (flowersCount < 80 && flowerType.equals("Gladiolus")) {
            price += price * 0.2;
        } else {
            price = price;
        }
        double difference = budget - price;
        if (budget >= price) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount,flowerType, difference);
        } else {
            difference = Math.abs(difference);
            System.out.printf("Not enough money, you need %.2f leva more.", difference);

        }
    }
}
