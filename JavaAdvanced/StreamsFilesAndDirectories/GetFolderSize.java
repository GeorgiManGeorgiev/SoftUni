package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\GeorgiManGeorgiev\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources(1)\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";




        File file = new File(path);

        long size = 0;
        for (File innerFile : file.listFiles()) {
            size+= innerFile.length();
        }
        System.out.println("Folder size: " + size);

    }
}
