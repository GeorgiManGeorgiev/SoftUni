package B_FM.FinalExam;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String input = "";
        while (!"Complete".equals(input = scanner.nextLine())) {
            String[] commands = input.split("\\s+");

            switch (commands[0]) {

                case "Make":
                    if (commands[1].equals("Upper")) {
                        email = email.toUpperCase();
                        System.out.println(email);
                    }
                    if (commands[1].equals("Lower")) {
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(commands[1]);
                    int startIndex = email.length() - count;
                    String sub = email.substring(startIndex);
                    System.out.println(sub);
                    break;
                case "GetUsername":
                    int endIndex = email.indexOf('@');
                    if (endIndex == -1) {
                        System.out.println(String.format("The email %s doesn't contain the @ symbol.", email));
                    } else {
                        sub = email.substring(0, endIndex);
                        System.out.println(sub);
                    }
                    break;
                case "Replace":
                    String toReplace = commands[1];
                    email = email.replace(toReplace, "-");
                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length(); i++) {
                        int curr = email.charAt(i);
                        System.out.print(curr + " ");
                    }
                    break;
            }
        }
    }
}
