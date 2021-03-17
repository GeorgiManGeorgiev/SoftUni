package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources(1)\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt";

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter( outputStream));
        Files.readAllLines(Path.of(path))
                .forEach(str-> {
                    try {
                        writer.write (str.toUpperCase());
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                });
        writer.close();
    }
}
