package B_FM.FinalExam.Exam;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        String input = "";
        while (!"Generate".equals(input = scanner.nextLine())) {
            String[] commands = input.split(">>>");

            switch (commands[0]) {
                case "Contains":
                    String substring = commands[1];
                    if (activationKey.contains(substring)) {
                        System.out.println(String.format("%s contains %s", activationKey, substring));
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = commands[1];
                    int startIndex = Integer.parseInt(commands[2]);
                    int endIndex = Integer.parseInt(commands[3]);
                    String sub = activationKey.substring(startIndex, endIndex);
                    String toReplace = "";
                    if (upperOrLower.equals("Upper")) {
                    toReplace = sub.toUpperCase();
                    }if (upperOrLower.equals("Lower")){
                        toReplace = sub.toLowerCase();
                }
                    activationKey = activationKey.replace(sub,toReplace);
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(commands[1]);
                    endIndex = Integer.parseInt(commands[2]);
                    sub = activationKey.substring(startIndex,endIndex);
                    activationKey = activationKey.replace(sub,"");
                    System.out.println(activationKey);
                    break;

            }
        }
        System.out.println(String.format("Your activation key is: %s",activationKey));
    }
}
