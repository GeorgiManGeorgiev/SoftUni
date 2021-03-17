package B_FM.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Character> chars = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c > 47 && c < 58) {
                int current = Integer.parseInt(String.valueOf(c));
                numbers.add(current);
            } else {
                chars.add(c);
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int n = numbers.get(i);
            if (i % 2 == 0) {

                takeList.add(n);
            } else {
                skipList.add(n);
            }
        }
        String result = "";
        int poss = 0;
        for (int i = 0; i < takeList.size(); i++) {
            int toTake = takeList.get(i);
            int toSkip = skipList.get(i);
            if (toTake > 0) {

                for (int j = 0; j < toTake; j++) {
                    if (poss>chars.size()-1){
                        break;
                    }
                    result += chars.get(poss);
                    poss++;
                }
            }
            if (toSkip > 0) {
                poss += toSkip;
            }
        }

        System.out.println(result);
    }
}
