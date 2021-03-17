package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) throws FileNotFoundException {


        String pathOne = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources(1)" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputOne.txt";
        String pathTwo = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources(1)" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputTwo.txt";

        Scanner scanner = new Scanner(new File(pathOne));

        PrintWriter writer = new PrintWriter("MergeOutput.txt");

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            writer.append(line).append(System.lineSeparator());
        }
        scanner = new Scanner(new File(pathTwo));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            writer.append(line).append(System.lineSeparator());
        }
        writer.close();

    }
}
