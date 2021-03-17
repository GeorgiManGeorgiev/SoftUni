package B_FM.nextLectures.basic;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        String password = scanner.nextLine();

        int count = 1;
        int userNameAsInt = userName.length();
        StringBuilder pass = new StringBuilder();
        for (int i = userNameAsInt - 1; i >= 0; i--) {
            char current = userName.charAt(i);
            pass.append(current);
        }
        while (!password.contentEquals(pass)) {
            if (count >= 4) {
                break;
            }
            System.out.printf("Incorrect password. Try again.%n");
            password = scanner.nextLine();
            count++;
        }
        if (password.contentEquals(pass)) {
            System.out.printf("User %s logged in.", userName);
        } else {
            System.out.printf("User %s blocked!", userName);
        }
    }
}
