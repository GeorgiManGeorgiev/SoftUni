package B_FM.List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int index = 0;
        char charTo =' ';
        String charToGet = "";

        for (int element :
                numbers) {
            index = 0;
            while (element > 0) {
                index += element % 10;
                element = element / 10;
            }
            int length = input.length();
            if (index > length - 1) {
                index = index - length;
            }
            charTo = input.charAt(index);
            charToGet = charTo + "";
            System.out.print(charToGet);
            input = input.replaceFirst(charToGet, "");
        }


    }


}
