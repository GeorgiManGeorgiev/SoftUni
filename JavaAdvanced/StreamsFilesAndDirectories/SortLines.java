package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String basePath = "C:\\Users\\GeorgiManGeorgiev\\Downloads"
                + "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\"
                + "04. Java-Advanced-Files-and-Streams-Lab-Resources\\";

        String inputRawPath = basePath + "input.txt";
        String outputRawPath = basePath + "sorted.txt";

        Path inputPath = Paths.get(inputRawPath);
        Path outputPath = Paths.get(outputRawPath);

        List<String> allLines = Files.readAllLines(inputPath);

        Collections.sort(allLines);
        Files.write(outputPath,allLines);
    }
}
