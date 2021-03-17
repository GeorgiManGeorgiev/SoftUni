package C_JavaAdvanced.JavaAdv.StreamsFilesAndDirectories;

import java.io.*;

public class Serialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("red",1.2,3.4,5.5);

        String basePath = "C:\\Users\\GeorgiManGeorgiev\\Downloads"
                + "\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\"
                + "04. Java-Advanced-Files-and-Streams-Lab-Resources\\";

        String inputPath = basePath + "cube.ser";
        String outputPath = basePath + "cube.ser";

        try( FileOutputStream outputStream = new FileOutputStream(outputPath);
        ObjectOutputStream writer = new ObjectOutputStream(outputStream)){
            writer.writeObject(cube);
        }

        try( FileInputStream inputStream = new FileInputStream(inputPath);
             ObjectInputStream reader = new ObjectInputStream(inputStream)){
           Cube read = (Cube) reader.readObject();
            System.out.println(read.color);
        }
    }
}

class Cube implements Serializable{

    String color;
    double width;
    double height;
    double depth;

    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}