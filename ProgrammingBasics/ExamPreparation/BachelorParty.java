package A_PB.ExamPreparation;

        import java.util.Scanner;

public class BachelorParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalGuestCount = 0;
        int totalSum = 0;
        int guestSingerPrice = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("The restaurant is full")) {
            int guestCount = Integer.parseInt(input);
            int personPrice = 100;
            if (guestCount >= 5) {
                personPrice = 70;
            }

            totalSum += guestCount * personPrice;
            totalGuestCount += guestCount;
            input = scanner.nextLine();
        }
        if (totalSum >= guestSingerPrice) {
            System.out.printf("You have %d guests and %d leva left.", totalGuestCount, (totalSum - guestSingerPrice));
        } else {
            System.out.printf("You have %d guests and %d leva income, but no singer.", totalGuestCount, totalSum);
        }

    }
}
