package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteToFile { public static void main(String[] args) throws IOException {
    String path = "C:\\Users\\GeorgiManGeorgiev\\Downloads"
            + "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\"
            + "04. Java-Advanced-Files-and-Streams-Lab-Resources\\"
            + "input.txt";

    FileInputStream inputStream = new FileInputStream(path);

    int readByte = inputStream.read();
    while (readByte >= 0) {
        System.out.print(Integer.toBinaryString(readByte)+" ");

        readByte = inputStream.read();
    }

}
}
