package B_FM.nextLectures.DataTypesAndVariables;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int first = 97; first < 97 + n; first++) {
            for (int second = 97; second < 97 + n; second++) {
                for (int third = 97; third < 97 + n; third++) {
                    System.out.printf("%c%c%c%n",first,second,third);
                }
            }
        }
    }
}
