package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.*;
import java.util.*;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\GeorgiManGeorgiev\\Downloads"
                + "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\"
                + "04. Java-Advanced-Files-and-Streams-Lab-Resources\\";

        String inputPath = basePath + "input.txt";
        String outputPath = basePath + "integers.txt";


        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {

            Scanner scanner = new Scanner(inputStream);

            PrintStream writer = new PrintStream(outputStream);

            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    int number = scanner.nextInt();
                    writer.println(number);

                }
                scanner.next();
            }

        } catch (IOException e) {
            System.out.println("Really bad");
        }


    }
}
