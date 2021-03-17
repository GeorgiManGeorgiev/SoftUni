package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class LineNumbers {
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        String path = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources(1)" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputLineNumbers.txt";

        PrintWriter writer = new PrintWriter("lineNumber.txt");

        Scanner scanner = new Scanner(Path.of(path));


        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            Arrays.stream(line.split("\n"))
                    .forEach(str -> {
                        writer.printf("%d. %s%n", count, str);

                    });
            count++;
        }

        writer.close();


    }
}
