package B_FM.RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
        List<String> emails = new ArrayList<>();
        String regex = "(?<user>[a-z0-9]{1,}[.\\-_]?[a-z0-9]+)@(?<host>[\\.\\-a-z0-9]*[a-z0-9]\\.[a-z]{2,})";
          Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                 emails.add(matcher.group());
            }

                emails.stream().forEach(e->{
                    System.out.println(e.trim());
                });
    }
}


