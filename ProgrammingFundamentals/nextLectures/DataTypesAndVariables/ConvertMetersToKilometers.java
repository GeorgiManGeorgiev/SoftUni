package B_FM.nextLectures.DataTypesAndVariables;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        int meters = new Scanner(System.in).nextInt();
        double kilometers = meters / 1000.0;
        System.out.printf("%.2f", kilometers);
    }
}
