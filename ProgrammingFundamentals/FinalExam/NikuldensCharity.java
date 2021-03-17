package B_FM.FinalExam;

import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String command = scanner.nextLine();
        while (!"Finish".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Replace":
                    String toReplace = tokens[1];
                    String newChar = tokens[2];
                    string = string.replace(toReplace, newChar);
                    System.out.println(string);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < string.length() && endIndex < string.length() && endIndex >= 0) {
                        String substring = string.substring(startIndex, endIndex + 1);
                        string = string.replace(substring, "");
                        System.out.println(string);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
                case "Make":
                    String toUpperOrLower = tokens[1];
                    if ("Upper".equals(toUpperOrLower)) {
                        string = string.toUpperCase();
                    }
                    if ("Lower".equals(toUpperOrLower)) {
                        string = string.toLowerCase();
                    }
                    System.out.println(string);
                    break;
                case "Check":
                    String toCheck = tokens[1];
                    if (string.contains(toCheck)) {
                        System.out.println(String.format("Message contains %s", toCheck));
                    } else {
                        System.out.println(String.format("Message doesn't contain %s", toCheck));
                    }
                    break;
                case "Sum":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    int sum = 0;
                    if (startIndex >= 0 && startIndex < string.length() && endIndex < string.length() && endIndex >= 0) {
                        String substring = string.substring(startIndex, endIndex + 1);
                        for (int i = 0; i < substring.length(); i++) {
                            int curr = substring.charAt(i);
                            sum += curr;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
            }
            command = scanner.nextLine();

        }
    }
}
