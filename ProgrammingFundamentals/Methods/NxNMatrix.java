package B_FM.Methods;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printNxNMatrix(n);

    }

    private static void printNxNMatrix(int n) {
        for (int c = 0; c < n; c++) {
            for (int i = 0; i < n; i++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
