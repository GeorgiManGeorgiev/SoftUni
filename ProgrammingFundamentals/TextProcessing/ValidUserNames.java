package B_FM.TextProcessing;

import java.util.Scanner;

public class ValidUserNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] userNames = scanner.nextLine().split(", ");

        for (int i = 0; i < userNames.length; i++) {
            String userName = userNames[i];

            if (userName.length() >= 3 && userName.length() <= 16) {
                boolean isUserNameValid = false;
                for (int j = 0; j < userName.length(); j++) {
                    if (Character.isDigit(userName.charAt(j)) ||
                            Character.isLetter(userName.charAt(j)) ||
                            userName.charAt(j) == '-' ||
                            userName.charAt(j) == '_') {
                        isUserNameValid = true;
                    } else {
                        isUserNameValid = false;
                        break;
                    }

                }
                if (isUserNameValid) {
                    System.out.println(userName);
                }
            }

        }

    }
}
