package B_FM.RegEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        Map<String, Integer> participants = new LinkedHashMap<>();
        String[] names = line.split(", ");
        Arrays.stream(names).forEach(n -> participants.put(n,0));

        line = reader.readLine();

        while (!line.equals("end of race")){
            Pattern patternNames = Pattern.compile("[A-Za-z]+");
            Matcher matcherNames = patternNames.matcher(line);
            StringBuilder name = new StringBuilder();
            while (matcherNames.find()){
                name.append(matcherNames.group());
            }

            if (participants.containsKey(name.toString())){
                patternNames = Pattern.compile("\\d");
                matcherNames = patternNames.matcher(line);
                while (matcherNames.find()){
                    int digit = Integer.parseInt(matcherNames.group());
                    participants.put(name.toString(),participants.get(name.toString()) + digit);
                }
            }


            line = reader.readLine();
        }
        int[] id = {1};
        participants.entrySet().stream().sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue())).limit(3).forEach(
                n -> {
                    switch (id[0]){
                        case 1 :
                            System.out.print("1st place: ");
                            break;
                        case 2:
                            System.out.print("2nd place: ");
                            break;
                        case 3:
                            System.out.print("3rd place: ");
                            break;
                    }
                    System.out.println(n.getKey());
                    id[0] += 1;
                }
        );


    }
}