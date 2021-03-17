package B_FM.AssociativeArrays;

        import java.util.LinkedHashMap;
        import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"stop".equals(input)) {

            int count = Integer.parseInt(scanner.nextLine());

            resources.putIfAbsent(input,0);
            int oldCount = resources.get(input);
            resources.put(input, oldCount + count);

            input = scanner.nextLine();
        }

        resources
                .forEach((k,v) -> System.out.println(String.format("%s -> %d",k,v)));
    }
}
