package B_FM.MidExam.MidExam;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        int countOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int  studentAttendance = 0;

        for (int i = 1; i <= countOfStudents; i++) {
            int studentAttendanceCount = Integer.parseInt(scanner.nextLine());
            double studentBonus = (studentAttendanceCount * 1.0) / countOfLectures * (5 + additionalBonus);
           if (studentBonus>maxBonus){
               maxBonus = studentBonus;
               studentAttendance = studentAttendanceCount;
           }
        }
        double maxBonusRound = Math.ceil(maxBonus);
        int maxBonusInt = (int) maxBonusRound;
        System.out.printf("Max Bonus: %d.%nThe student has attended %d lectures."
                ,maxBonusInt,studentAttendance);
    }
}
