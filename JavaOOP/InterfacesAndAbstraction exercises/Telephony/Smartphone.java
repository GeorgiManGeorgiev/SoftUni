package P05_telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : this.urls) {
            Pattern pattern = Pattern.compile("^[\\D]+$");
            Matcher matcher = pattern.matcher(url);

            if (matcher.matches()){
                sb.append(String.format("Browsing: %s!",url));
            }else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (isNumberValid(number)) {
                sb.append(String.format("Calling... %s", number));
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private boolean isNumberValid(String number) {
        for (int i = 0; i < number.length(); i++) {
            char curr = number.charAt(i);
            if (!Character.isDigit(curr)) {
                return false;
            }
        }
        return true;
    }

}
