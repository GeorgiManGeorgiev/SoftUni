package B_FM.nextLectures.DataTypesAndVariables;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int begin = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int index = begin; index <= end; index++) {
            System.out.print((char) index + " ");
        }
    }
}
