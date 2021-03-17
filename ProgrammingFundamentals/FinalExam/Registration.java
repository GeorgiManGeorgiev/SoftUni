package B_FM.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int successfulRegistrationsCount = 0;

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}[\\d]+)P@\\$";
        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i < n; i++) {
            String registration = scanner.nextLine();

            Matcher matcher = pattern.matcher(registration);
            if (matcher.find()) {
                successfulRegistrationsCount++;
                String username = matcher.group("username");
                String password = matcher.group("password");
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", username, password);
            } else {
                System.out.println("Invalid username or password");
            }

        }
        System.out.println(String.format("Successful registrations: %s", successfulRegistrationsCount));
    }
}
