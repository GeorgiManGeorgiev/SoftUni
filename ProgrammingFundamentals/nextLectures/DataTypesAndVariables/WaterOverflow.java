package B_FM.nextLectures.DataTypesAndVariables;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int totalLiters = 0;
        while (n-->0){
            int liters = Integer.parseInt(scanner.nextLine());
            if(capacity>=liters){
            capacity-=liters;
            totalLiters+=liters;
        }else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(totalLiters);
    }
}
