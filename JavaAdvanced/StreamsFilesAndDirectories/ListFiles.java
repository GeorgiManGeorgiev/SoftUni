package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;


import java.io.File;
import java.io.IOException;


public class ListFiles {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\GeorgiManGeorgiev\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\" +
                "Files-and-Streams";

            
        File file = new File(path);

        File[] files = file.listFiles();

        for (File current : files) {
            if (!current.isDirectory()) {
                System.out.printf("%s: [%d]%n", current.getName(), current.length());
            }
        }
    }
}
