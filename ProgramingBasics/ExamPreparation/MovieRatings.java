package A_PB.ExamPreparation;

import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int movieCount = Integer.parseInt(scanner.nextLine());

        double maxRating = 1;
        String maxRatingMovie = "";
        double minRating = 10;
        String minRatingMovie = "";
        double totalSumRating = 0;

        for (int i = 1; i <= movieCount; i++) {
            String movieName = scanner.nextLine();
            double rating = Double.parseDouble(scanner.nextLine());
            totalSumRating += rating;

            if (rating > maxRating) {
                maxRating = rating;
                maxRatingMovie = movieName;
            }
            if (rating < minRating) {
                minRating = rating;
                minRatingMovie = movieName;
            }

        }
        double averageRating = totalSumRating / movieCount;
        System.out.printf("%s is with highest rating: %.1f%n",maxRatingMovie,maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n",minRatingMovie,minRating);
        System.out.printf("Average rating: %.1f%n",averageRating);
    }
}