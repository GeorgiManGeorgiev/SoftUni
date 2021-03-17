package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class TailorShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coverPricePerMeterUSD = 7;
        int squarePricePerMeterUSD = 9;
        double usdToBgnRate = 1.85;
        int tablesCount = Integer.parseInt(scanner.nextLine());
        double tableLength = Double.parseDouble(scanner.nextLine());
        double tableWidth = Double.parseDouble(scanner.nextLine());
        double squareSide = (tableLength / 2);
        double squareArea = Math.pow(squareSide, 2);
        double coverWidth = tableWidth + 0.60;
        double coverLength = tableLength + 0.60;
        double coverArea = coverLength * coverWidth;
        double coversArea = coverArea * tablesCount;
        double squaresArea = squareArea * tablesCount;
        double coversPriceUSD = coversArea * coverPricePerMeterUSD;
        double squaresPriceUSD = squaresArea * squarePricePerMeterUSD;
        double totalPriceUSD = coversPriceUSD + squaresPriceUSD;
        double totalPriceBGN = totalPriceUSD * usdToBgnRate;
        System.out.printf("%.2f USD %n", totalPriceUSD);
        System.out.printf("%.2f BGN", totalPriceBGN);

    }
}
