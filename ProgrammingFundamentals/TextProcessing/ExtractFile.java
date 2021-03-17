package B_FM.TextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path =scanner.nextLine();

        int slash = path.lastIndexOf('\\');
        int pointIndex = path.lastIndexOf('.');
        String name = path.substring(slash + 1, pointIndex);
        String extension = path.substring(pointIndex + 1);
        System.out.println(String.format("File name: %s",name));
        System.out.println(String.format("File extension: %s", extension));
    }
}
