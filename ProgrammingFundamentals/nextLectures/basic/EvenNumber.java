package B_FM.nextLectures.basic;

        import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Math.abs(Integer.parseInt(scanner.nextLine()));
        while (input % 2 == 1) {
            System.out.println("Please write an even number.");
            input = Math.abs(Integer.parseInt(scanner.nextLine()));
        }
        System.out.printf("The number is: %d", input);
    }
}
