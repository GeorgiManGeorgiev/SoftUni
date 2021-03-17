package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.*;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;


public class CountCharacterTypes {

    public static int[] counts = new int[3];

    public static void main(String[] args) throws IOException {
        String path = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources(1)" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt";


        PrintWriter writer = new PrintWriter("outputCount.txt");

        Scanner scanner = new Scanner(Path.of(path));
        String vowels = "aeiou";
        String punctuations = "!,.?";

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Arrays.stream(line.split("\\s+"))
                    .forEach(str -> {
                        for (char symbol : str.toCharArray()) {
                            String currentString = String.valueOf(symbol);
                            if (vowels.contains(currentString)) {
                                counts[0]++;
                            } else if (punctuations.contains(currentString)) {
                                counts[2]++;
                            } else {
                                counts[1]++;
                            }
                        }
                    });

        }
        writer.printf("Vowels: %d%n", counts[0]);
        writer.printf("Consonants: %d%n", counts[1]);
        writer.printf("Punctuation: %d", counts[2]);
        writer.close();
    }
}

