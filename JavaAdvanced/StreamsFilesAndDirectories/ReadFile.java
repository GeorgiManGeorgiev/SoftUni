package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.*;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\GeorgiManGeorgiev\\Downloads"
                + "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\"
                + "04. Java-Advanced-Files-and-Streams-Lab-Resources\\";

        String inputPath = basePath + "input.txt";
        String outputPath = basePath + "output2.txt";

        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;

        try{
            inputStream = new FileInputStream(inputPath);
            outputStream = new FileOutputStream(outputPath);

            Scanner scanner = new Scanner(inputStream);



            int readByte = inputStream.read();
            while (readByte >= 0) {
                char charByte = (char) readByte;
                if (readByte == ' ' || readByte== '\n') {
                    outputStream.write(charByte);
                }else{
                    String digit = String.valueOf(readByte);
                    for (int i = 0; i < digit.length() ; i++) {
                       outputStream.write( digit.charAt(i));
                    }

                }


                readByte = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println("Really bad");
        } finally {
            if (outputStream != null) {
                outputStream.close();
                {

                }
            }
        }
    }
}
