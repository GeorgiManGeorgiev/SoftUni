package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0;
        if (city.equalsIgnoreCase("Sofia")) {
            if (product.equalsIgnoreCase("coffee")) {
                price = 0.50 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("water")) {
                price = 0.80 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("beer")) {
                price = 1.20 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("sweets")) {
                price = 1.45 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("peanuts")) {
                price = 1.60 * quantity;
                System.out.println(price);
            }
        } else if (city.equalsIgnoreCase("Plovdiv")) {
            if (product.equalsIgnoreCase("coffee")) {
                price = 0.40 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("water")) {
                price = 0.70 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("beer")) {
                price = 1.15 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("sweets")) {
                price = 1.30 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("peanuts")) {
                price = 1.50 * quantity;
                System.out.println(price);
            }
        } else if (city.equalsIgnoreCase("Varna")) {
            if (product.equalsIgnoreCase("coffee")) {
                price = 0.45 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("water")) {
                price = 0.70 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("beer")) {
                price = 1.10 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("sweets")) {
                price = 1.35 * quantity;
                System.out.println(price);
            } else if (product.equalsIgnoreCase("peanuts")) {
                price = 1.55 * quantity;
                System.out.println(price);
            }
        }
    }
}
