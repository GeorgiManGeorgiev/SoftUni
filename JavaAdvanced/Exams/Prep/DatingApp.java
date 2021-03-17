package C_JavaAdvanced.JavaAdv.Exams.Prep;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] malesInput  = scanner.nextLine().split("\\s+");
        String[] femalesInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer>malesStack =new ArrayDeque<>();
        ArrayDeque<Integer>femalesQueue =new ArrayDeque<>();

        for (int i = 0; i < malesInput.length; i++) {
            malesStack.push(Integer.parseInt(malesInput [i]));
        }

        //fulfill stack of females
        for (int i = 0; i < femalesInput.length; i++) {
            femalesQueue.add(Integer.parseInt(femalesInput[i]));
        }


        int matches = 0;
        while (!femalesQueue.isEmpty() && !malesStack.isEmpty()) {
            int currFemale = femalesQueue.peek();
            int currMale = malesStack.peek();



            if (currMale <= 0) {
                malesStack.pop();
                continue;
            }
            if (currFemale <= 0) {
                femalesQueue.remove();
                continue;
            }

            if (currFemale % 25 == 0) {
                femalesQueue.remove();
                if (!femalesQueue.isEmpty()) {
                    femalesQueue.remove();
                }
                continue;
            }
            if (currMale % 25 == 0) {
                malesStack.pop();
                if (!malesStack.isEmpty()) {
                    malesStack.pop();
                }
                continue;
            }


            if (currFemale == currMale) {
                femalesQueue.remove();
                malesStack.pop();
                matches++;
            } else {
                femalesQueue.remove();
                malesStack.pop();
                malesStack.push(currMale-2);
            }

        }

            System.out.printf("Matches: %d%n", matches);

        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");

            List<String> malesResult = malesStack.stream().map(String::valueOf)
                    .collect(Collectors.toList());
            System.out.print(String.join(", ", malesResult).trim());
            System.out.println();

        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");

            List<String> femalesResult = femalesQueue.stream().map(String::valueOf)
                    .collect(Collectors.toList());
            System.out.print(String.join(", ", femalesResult).trim());
            System.out.println();

       }
    }
}
