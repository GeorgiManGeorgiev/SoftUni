package B_FM.nextLectures.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e)).toArray();

        int[] secondArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e)).toArray();

        int maxLength = 0;
        if (firstArr.length>=secondArr.length){
            maxLength=firstArr.length;
        }else {
            maxLength=secondArr.length;
        }
        int sum = 0;
        for (int i = 0; i < maxLength ; i++) {
            sum+=firstArr[i];
            if (firstArr[i]!=secondArr[i]){
                System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                return;
            }

        }System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}
