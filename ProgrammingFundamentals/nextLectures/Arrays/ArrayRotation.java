package B_FM.nextLectures.Arrays;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] number = new int[input.length];

        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(input[i]);
        }
        int rotations = Integer.parseInt(scanner.nextLine());

        rotations = rotations % number.length;

        for (int i = 0; i < rotations; i++) {
            int firstEl = number[0];
            for (int j = 0; j < number.length-1; j++) {
                number[j] = number[j + 1];
            }
            number[number.length - 1] = firstEl;


        }for (int j = 0; j < number.length; j++) {
            System.out.print(number[j] + " ");

        }
    }
}
//package com.company;
//
//import java.util.Scanner;
//
//public class EncryptSortPrintArray {
//    public static void ConsumerPrint(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String[] input = scanner.nextLine().split(" ");
//        int n = Integer.parseInt(scanner.nextLine());
//
//        for (int i = 0; i < n; i++) {
//            String firstString = input[0];
//            for (int j = 0; j <input.length-1; j++) {
//                input[j] = input[j+1];
//            }
//            input[input.length-1]= firstString;
//        }
//        System.out.println(String.join(" ",input));
//
//    }
//}