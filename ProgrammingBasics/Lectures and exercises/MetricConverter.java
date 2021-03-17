package A_PB.pastLectures.oneToTen;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        String numValue = scanner.nextLine();
        String numOutValue = scanner.nextLine();
        double numMm = 0;
        double result = 0;
        if(numValue.equalsIgnoreCase("mm")){
            numMm = num;
        }else if (numValue.equalsIgnoreCase("cm")){
            numMm = num * 10;
        }else if (numValue.equalsIgnoreCase("m")){
            numMm = num * 1000;
        }if (numOutValue.equalsIgnoreCase("mm")){
            result = numMm;
        }else if (numOutValue.equalsIgnoreCase("cm")){
            result = numMm / 10;
        }else if (numOutValue.equalsIgnoreCase("m")){
            result = numMm / 1000;
        }
        System.out.printf("%.3f",result);
    }
}
