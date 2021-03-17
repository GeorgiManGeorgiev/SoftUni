package B_FM.RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        String valid = ">>(?<type>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]+)!(?<quantity>\\d+)";
        Pattern regex = Pattern.compile(valid);

        double cost = 0.0;
        List<String> names = new ArrayList<>();
        while (!input.equals("Purchase")) {

            Matcher matcher = regex.matcher(input);

            while (matcher.find()){

                String name = matcher.group("type");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                names.add(name);
                cost+= price*quantity;
            }
            input = scanner.nextLine();

        }
        System.out.println("Bought furniture:");
        for (String name :
                names) {
            System.out.println(name);
        }
        System.out.printf("Total money spend: %.2f",cost);
    }
}
