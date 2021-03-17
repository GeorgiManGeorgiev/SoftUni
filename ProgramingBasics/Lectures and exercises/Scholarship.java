package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double income = Double.parseDouble(scanner.nextLine());
        double averageGrade = Double.parseDouble(scanner.nextLine());
        double minSalary = Double.parseDouble(scanner.nextLine());
        boolean socialScholarship = false;
        double socialScholarshipAmount = 0;
        if (income < minSalary && averageGrade > 4.50) {
            socialScholarship = true;
            socialScholarshipAmount = minSalary * 0.35;
        }
        boolean excellentResultScholarship = false;
        double excellentResultScholarshipAmount = 0;
        if (averageGrade >= 5.50) {
            excellentResultScholarship = true;
            excellentResultScholarshipAmount = averageGrade * 25;
        }
        if (socialScholarship && !excellentResultScholarship) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarshipAmount));
        } else if (!socialScholarship && excellentResultScholarship) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentResultScholarshipAmount));
        } else if (socialScholarship && excellentResultScholarship) {
            if (socialScholarshipAmount > excellentResultScholarshipAmount) {
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarshipAmount));
            } else {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellentResultScholarshipAmount));
            }
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}

