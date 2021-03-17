package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfBook = scanner.nextLine();
        int booksCount = Integer.parseInt(scanner.nextLine());
        int checkedBooksCount = 0;
        boolean isFound = false;
        while (checkedBooksCount < booksCount) {
            String currentBookName = scanner.nextLine();
            if (currentBookName.equals(nameOfBook)) {
                isFound = true;
                break;
            }
            checkedBooksCount++;

        }
        if (isFound) {
            System.out.printf("You checked %d books and found it.", checkedBooksCount);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", checkedBooksCount);
        }
    }
}
