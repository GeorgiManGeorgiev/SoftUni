package B_FM.nextLectures.DataTypesAndVariables;

import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int centuries = Integer.parseInt(scanner.nextLine());
        int years = centuries * 100;
        int days = (int) (years * 365.2422);
        int hours = 24* days;
        int min = 60* hours;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes"
                ,centuries,years,days,hours,min);
    }
}
