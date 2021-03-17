package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\GeorgiManGeorgiev\\Downloads"
                + "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\"
                + "04. Java-Advanced-Files-and-Streams-Lab-Resources\\";

        String inputPath = basePath + "input.txt";
        String outputPath = basePath + "third.txt";


        try (FileReader inputReader = new FileReader(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {


            BufferedReader reader = new BufferedReader(inputReader);
            PrintStream writer = new PrintStream(outputStream);

            int counter = 1;
            String line = reader.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    writer.println(line);
                }
                counter++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Really bad");
        }


    }


}
