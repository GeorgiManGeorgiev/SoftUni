package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double speedRecord = Double.parseDouble(scanner.nextLine());
        double metersToSwim = Double.parseDouble(scanner.nextLine());
        double timeInSecondForMeter = Double.parseDouble(scanner.nextLine());
        double timeNeeded = metersToSwim * timeInSecondForMeter;
        double totalTimeNeeded = timeNeeded + (12.5 * Math.floor(metersToSwim / 15));
        double timeVsRecordTime = Math.abs(totalTimeNeeded - speedRecord);
        if (speedRecord <= totalTimeNeeded) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeVsRecordTime);
        } else if (speedRecord > totalTimeNeeded) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTimeNeeded);
        }
    }
}
