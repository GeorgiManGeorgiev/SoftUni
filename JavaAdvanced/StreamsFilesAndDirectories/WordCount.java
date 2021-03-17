package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import B_FM.nextLectures.basic.PrintAndSum;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    private static Map<String, Integer> wordCount = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String pathOfWords = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources(1)" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\words.txt";

        String pathOfText = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources(1)" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\text.txt";




        Scanner scanner = new Scanner(Path.of(pathOfWords));


        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Arrays.stream(line.split("\\s+"))
                    .forEach(str -> {
                        wordCount.put(str, 0);
                    });
        }
        scanner = new Scanner(Path.of(pathOfText));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Arrays.stream(line.split("\\s+"))
                    .forEach(str -> {
                        if (wordCount.containsKey(str)) {
                            wordCount.put(str, wordCount.get(str) + 1);
                        }
                    });

        }

        wordCount
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    return s.getValue() - f.getValue();
                }).forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });



    }
}
