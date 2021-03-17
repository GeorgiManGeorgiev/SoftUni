package C_JavaAdvanced.JavaAdv.MultidimensionalArrays;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        int[][] foo = new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 1, 2, 3, 4},
                new int[] { 1, 2, 3, 4,},
        };

        System.out.println(foo.length); //2 returns rowsCount
        System.out.println(foo[0].length); //3 returns colsCount for row[0]
        System.out.println(foo[1].length); //4
        System.out.println(foo[2].length); //4

   }
}
