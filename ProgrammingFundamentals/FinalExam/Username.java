package B_FM.FinalExam;

import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Sign up".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Case":
                    if ("lower".equals(tokens[1])) {
                        username = username.toLowerCase();
                    } else {
                        username = username.toUpperCase();
                    }
                    System.out.println(username);
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && endIndex < username.length()) {
                        String result = username.substring(startIndex, endIndex + 1);
                        StringBuilder sb = new StringBuilder(result);
                        System.out.println(sb.reverse());
                    }
                    break;
                case "Cut":
                    String substring = tokens[1];
                    if (username.contains(substring)) {
                        username = username.replace(substring, "");
                        System.out.println(username);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", username, substring);
                    }
                    break;
                case "Replace":
                    username = username.replace(tokens[1],"*");
                    System.out.println(username);
                    break;
                case "Check":
                    if (username.contains(tokens[1])){
                        System.out.println("Valid");
                    }else {
                        System.out.println(String.format( "Your username must contain %s.",tokens[1]));
                    }
                    break;
            }


            input = scanner.nextLine();
        }
    }
}
