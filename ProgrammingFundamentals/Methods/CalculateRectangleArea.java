package B_FM.Methods;

        import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println(getArea(a,b));
    }

    private static int getArea(int a, int b) {
        int result = a * b;
        return result;
    }
}
