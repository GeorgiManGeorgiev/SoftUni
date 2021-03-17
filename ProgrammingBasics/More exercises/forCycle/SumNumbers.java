package A_PB.pastLectures.forCycle;

        import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int num = 0;
        for (int i=1; i<=n; i++ ){
            num = num + Integer.parseInt(scanner.nextLine());
        }
        System.out.println(num);
    }
}
