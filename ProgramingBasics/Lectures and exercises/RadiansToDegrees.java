package A_PB.pastLectures.oneToTen;

        import java.util.Scanner;

public class RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read rad
        double radians = Double.parseDouble(scanner.nextLine());
        //  convert deg = rad * 180 / PI
        double degrees = radians * 180 / Math.PI;
        // format "%.0f"
        System.out.printf("%.0f", degrees);
    }
}
