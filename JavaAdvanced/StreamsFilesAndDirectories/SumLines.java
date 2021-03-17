package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources(1)\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt";
        Files.readAllLines(Path.of(path))
                .stream()
                .map(String::toCharArray)
                .forEach(c -> {
                    int bytes = 0;
                    for (char symbol :
                            c) {
                        bytes += symbol;
                    }
                    System.out.println(bytes);
                });
    }
}
