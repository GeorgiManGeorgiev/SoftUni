package B_FM.AssociativeArrays;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companies = new HashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String id = tokens[1];
            if (!companies.containsKey(companyName)) {

                companies.put(companyName, new LinkedList<>());
                companies.get(companyName).add(id);

            } else {
                if (!companies.get(companyName).contains(id)) {
                    companies.get(companyName).add(id);
                }
            }

            input = scanner.nextLine();
        }
        companies
                .entrySet()
                .stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue()
                            .forEach(id -> System.out.println("-- " + id));

                });
    }
}
