package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class USDtoBGNConvertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double usdInput = Double.parseDouble(scanner.nextLine());
        double result = usdInput * 1.79549;
        System.out.printf("%.2f", result);
    }
}
