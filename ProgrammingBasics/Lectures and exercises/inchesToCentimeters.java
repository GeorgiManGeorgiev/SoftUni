package A_PB.pastLectures.oneToTen;

import java.util.Scanner;
public class inchesToCentimeters {
    public static void main(String[] args) {
        // 1.read and store input
        Scanner scanner = new Scanner(System.in);
        double inches = Double.parseDouble(scanner.nextLine());
        // 2. calculate cm ( input * 2.54)
        double cm = inches * 2.54;
        // 3. Print and format to second decimal sign
        System.out.printf("%.2f", cm);
    }
}
