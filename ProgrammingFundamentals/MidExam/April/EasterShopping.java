package B_FM.MidExam.April;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shops = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]) {
                case "Include":
                    String shopToInclude = commands[1];
                    shops.add(shopToInclude);
                    break;
                case "Visit":
                    String firstOrLast = commands[1];
                    int removeCount = Integer.parseInt(commands[2]);
                    if (shops.size() > removeCount) {
                        if (firstOrLast.equals("first")) {
                            for (int j = 0; j < removeCount; j++) {
                                if (shops.size() == 0) {
                                    break;
                                }
                                shops.remove(0);
                            }
                        }
                        if (firstOrLast.equals("last")) {
                            for (int j = 0; j < removeCount; j++) {
                                if (shops.size() == 0) {
                                    break;
                                }
                                shops.remove(shops.size() - 1);
                            }
                        }
                    }
                    break;
                case "Prefer":
                    int indexOfFirstShop = Integer.parseInt(commands[1]);
                    int indexOfSecondShop = Integer.parseInt(commands[2]);
                    if (isValidIndex(shops, indexOfFirstShop)
                            && isValidIndex(shops, indexOfSecondShop)) {
                        String firstShop = shops.get(indexOfFirstShop);
                        String secondShop = shops.get(indexOfSecondShop);
                        shops.set(indexOfFirstShop, secondShop);
                        shops.set(indexOfSecondShop, firstShop);
                    }
                    break;
                case "Place":
                    String shopToPlace = commands[1];
                    int indexToPlace = Integer.parseInt(commands[2]) + 1;
                    if (indexToPlace >= 0 && indexToPlace <= shops.size()) {
                        shops.add(indexToPlace, shopToPlace);
                    }
                    break;
            }

        }

        System.out.println("Shops left:");
        for (String shop :
                shops) {
            System.out.print(shop + " ");
        }
    }

    private static boolean isValidIndex(List<String> shops, int index) {
        if (index >= 0 && index < shops.size()) {
            return true;
        }
        return false;
    }
}
