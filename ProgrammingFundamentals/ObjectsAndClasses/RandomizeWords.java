package B_FM.ObjectsAndClasses;

        import java.util.Random;
        import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Random random = new Random();

        for (int i = 0; i < words.length; i++) {

            int firstIndex = random.nextInt(words.length);
            int secondIndex = random.nextInt(words.length);
            String swapWord = words[firstIndex];
            words[firstIndex] = words[secondIndex];
            words[secondIndex] = swapWord;
        }
        System.out.println(String.join(System.lineSeparator(),words));
    }
}
