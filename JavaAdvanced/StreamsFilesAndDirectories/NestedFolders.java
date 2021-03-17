package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;



import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class NestedFolders {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\GeorgiManGeorgiev\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\";


        File file = new File(path);
        File[] files = file.listFiles();

        ArrayDeque<File> toTraverse = new ArrayDeque<>(Arrays.asList(files));
        int folderCount = 0;
        while (toTraverse.size() > 0) {
            File current = toTraverse.poll();

            if (current.isDirectory()) {
                System.out.println(current.getName());
                List<File> fileList = Arrays.asList(current.listFiles());
                toTraverse.addAll(fileList);
                folderCount++;
            }
        }
        System.out.println(folderCount + " folders");
    }
}
