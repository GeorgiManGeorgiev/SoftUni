package B_FM.FinalExam.Exam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int validEmojis = 0;
        long coolThreshold = 1L;
        List<String> coolEmojis = new ArrayList<>();

        String input = scanner.nextLine();

        Pattern patForCoolness = Pattern.compile("\\d");
        Matcher matcherForCoolness = patForCoolness.matcher(input);
        while (matcherForCoolness.find()) {
            int curr = Integer.parseInt(matcherForCoolness.group());
            coolThreshold *= curr;
        }


        String regex = "([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            validEmojis++;
            String emoji = matcher.group(2);
            int coolness = 0;
            for (int i = 0; i < emoji.length(); i++) {
                int curr = emoji.charAt(i);
                coolness += curr;
            }
            if (coolness > coolThreshold) {
                coolEmojis.add(matcher.group());
            }
        }


            System.out.println(String.format("Cool threshold: %d", coolThreshold));
            System.out.println(String.format("%d emojis found in the text. The cool ones are:", validEmojis));
        if (!coolEmojis.isEmpty()) {
            for (int i = 0; i < coolEmojis.size(); i++) {
                System.out.println(coolEmojis.get(i));
            }
        }
    }
}
