package B_FM.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String message = "";
            String commandToPrint = "";
            String command = scanner.nextLine();
            String regex = "!(?<first>[A-Z][a-z]{2,})!:\\[(?<second>[A-Za-z]{8,})\\]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                message = matcher.group("second");
                commandToPrint = matcher.group("first");

            } else {
                System.out.println("The message is invalid");
                continue;
            }
            System.out.print(commandToPrint + ":" + " ");
            for (int j = 0; j < message.length(); j++) {
                int number = message.charAt(j);
                System.out.print(number + " ");
            }
            System.out.println();

        }
    }
}
