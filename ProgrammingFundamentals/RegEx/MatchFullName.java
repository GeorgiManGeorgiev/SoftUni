package B_FM.RegEx;

        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern regex = Pattern.compile("\\b([A-Z][a-z]+ [A-Z][a-z]+)\\b");
        Matcher m  = regex.matcher(input);

        while (m.find()) {
            System.out.print(m.group(0) + " ");
        }
    }
}
