package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.*;


public class SumLinesWithBufferedReader {
    public static void main(String[] args) throws IOException {
        String path = "C:" +
                "\\Users" +
                "\\GeorgiManGeorgiev" +
                "\\Desktop\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources(1)\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt";



        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();

        while (line!=null) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
            line = reader.readLine();
        }
        reader.close();
    }
}
