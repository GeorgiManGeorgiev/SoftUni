package B_FM.MidExam.June;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Switch":
                    int index = Integer.parseInt(command[1]);
                    if (isValidIndex(arr, index)) {
                        int numToReverse = arr.get(index);
                        int numToInsert = 0;
                        if (numToReverse > 0) {
                            numToInsert = numToReverse  - (numToReverse*2);
                        } else {
                            numToInsert = numToReverse + (Math.abs(numToReverse)*2);
                        }
                        arr.set(index,numToInsert);
                    }
                    break;
                case "Change":
                    int indexToChange = Integer.parseInt(command[1]);
                    int value = Integer.parseInt(command[2]);
                    if (isValidIndex(arr,indexToChange)){
                        arr.set(indexToChange,value);
                    }
                    break;
                case "Sum":
                    if (command[1].equals("Negative")){
                    int negSum = 0;
                    for (Integer num :
                            arr) {
                        if (num<0){
                            negSum+=num;
                        }
                    }
                        System.out.println(negSum);
                        break;
                    }
               if(command[1].equals("Positive")){
                    int posSum = 0;
                    for (Integer num :
                            arr) {
                        if (num>0){
                            posSum+=num;
                        }
                    }
                   System.out.println(posSum);
                   break;
               }
                if (command[1].equals("All")){
                    int Sum = 0;
                    for (Integer num :
                            arr) {
                        if (num!=0){
                            Sum+=num;
                        }
                    }
                    System.out.println(Sum);
                    break;
                }
            }

            input = scanner.nextLine();
        }
        for (Integer integer : arr) {
            if (integer>=0) {
                System.out.print(integer + " ");
            }
        }
    }

    private static boolean isValidIndex(List<Integer> arr, int index) {
        if (index < arr.size() && index >= 0) {
            return true;
        }
        return false;
    }

}
