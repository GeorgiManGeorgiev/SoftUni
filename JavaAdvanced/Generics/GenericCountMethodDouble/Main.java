package C_JavaAdvanced.JavaAdv.Generics.GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Double>> boxes = new ArrayList<>();

        while (n-- > 0) {
            Box<Double> box = new Box<>((Double.parseDouble(scanner.nextLine())));
            boxes.add(box);

        }

        Box<Double> box = new Box<>((Double.parseDouble(scanner.nextLine())));

        System.out.println(findAllOccurrences(boxes,box));
    }

    private static<T extends Comparable> int findAllOccurrences(List<Box<T>> boxes,
               Box<T> box) {

        return (int)boxes.stream().filter(b -> 0 < b.getElement().compareTo(box.getElement()))
                .count();
    }
}
