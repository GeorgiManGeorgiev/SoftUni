package B_FM.Methods;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int repeatCount = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(s, repeatCount));
    }

    static String repeatString(String s, int repeatCount) {
        String[] repeatArr = new String[repeatCount];
        for (int i = 0; i < repeatArr.length; i++) {
            repeatArr[i] = s;
        }

        return String.join("", repeatArr);
    }
}
