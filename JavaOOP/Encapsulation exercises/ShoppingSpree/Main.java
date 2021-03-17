import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] peopleInput = reader.readLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();
        for (String in : peopleInput) {
            String[] tokens = in.split("=");
            people.putIfAbsent(tokens[0], new Person(tokens[0], Double.parseDouble(tokens[1])));
        }
        String[] productInput = reader.readLine().split(";");
        Map<String, Product> products = new HashMap<>();
        for (String pr : productInput) {
            String[] tokens = pr.split("=");
            products.putIfAbsent(tokens[0], new Product(tokens[0], Double.parseDouble(tokens[1])));
        }
        String line;
        while (!("END".equals(line = reader.readLine()))) {
            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            if (people.containsKey(personName)&& products.containsKey(productName)){
                Person person = people.get(personName);
                Product product = products.get(productName);

                person.buyProduct(product);
            }
        }
        for (Person p : people.values()) {
            System.out.println(p);
        }
    }
}
