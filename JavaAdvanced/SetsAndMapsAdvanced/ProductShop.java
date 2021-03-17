package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Double>> shops = new HashMap<>();

        String input = "";
        while (!"Revision".equals(input = scanner.nextLine())) {

            String [] tokens = input.split(", ");
            String shopName = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
           if (!shops.containsKey(shopName)){
               shops.put(shopName,new LinkedHashMap<>());
           }

           LinkedHashMap<String,Double> curr = shops.get(shopName);
           curr.put(product,price);
           shops.put(shopName,curr);

        }

        shops
                .entrySet()
                .stream()
                .sorted((s1,s2)->s1.getKey().compareTo(s2.getKey()))
                .forEach(e->{
                    System.out.println(e.getKey() + "->");
                    Map<String,Double> toPrint = e.getValue();
                    toPrint.entrySet().stream().forEach(el->{
                        System.out.printf("Product: %s, Price: %.1f%n",el.getKey(),el.getValue());
                    });
                });
    }
}
