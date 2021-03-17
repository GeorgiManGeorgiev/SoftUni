package A_PB.pastLectures.oneToTen;

        import java.util.Scanner;

public class AlcoholMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double whiskeyPricePerLitter = Double.parseDouble(scanner.nextLine());
        double beerCount = Double.parseDouble(scanner.nextLine());
        double wineCount = Double.parseDouble(scanner.nextLine());
        double rakiaCount = Double.parseDouble(scanner.nextLine());
        double whiskeyCount = Double.parseDouble(scanner.nextLine());
        double whiskeyTotalPrice = whiskeyCount * whiskeyPricePerLitter;
        double rakiaPricePerLiter = whiskeyPricePerLitter / 2;
        double rakiaTotalPrice = rakiaCount * rakiaPricePerLiter;
        double winePricePerliter = rakiaPricePerLiter - (rakiaPricePerLiter * 40 / 100);
        double wineTotalPrice = winePricePerliter * wineCount;
        double beerPrice = rakiaPricePerLiter - (rakiaPricePerLiter * 80 / 100);
        double totalBeerPrice = beerPrice * beerCount;
        double totalPrice = whiskeyTotalPrice + wineTotalPrice + rakiaTotalPrice + totalBeerPrice;
        System.out.printf("%.2f", totalPrice);
    }
}
