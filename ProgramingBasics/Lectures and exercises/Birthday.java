package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. Read and store tank dimensions data
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        // 2.Read percentage of stuff in tank
        double percenStuff = Double.parseDouble(scanner.nextLine());
        percenStuff = percenStuff / 100;
        int volume = length * width * height;
        double volumeStuff = volume * percenStuff;
        double finalVolume = volume - volumeStuff;
        // 3. calculate volume v= a*b*c print
        double liter = finalVolume / 1000;
        System.out.printf("%.3f", liter);
        // 4. calculate cubic cm to liters
        // 5. print "%.3f"
    }
}
