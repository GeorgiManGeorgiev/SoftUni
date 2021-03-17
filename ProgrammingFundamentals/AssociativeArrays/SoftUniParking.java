package B_FM.AssociativeArrays;

        import java.util.LinkedHashMap;
        import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> parking = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String userName = tokens[1];
            if ("register".equals(command)) {
                String number = tokens[2];
                if (parking.containsKey(userName)) {
                    String id = parking.get(userName);
                    System.out.println(String.format("ERROR: already registered with plate number %s", id));
                } else {
                    parking.put(userName, number);
                    System.out.println(String.format("%s registered %s successfully", userName, number));
                }
            } else {
                if (parking.containsKey(userName)) {
                    parking.remove(userName);
                    System.out.println(String.format("%s unregistered successfully", userName));
                } else {
                    System.out.println(String.format("ERROR: user %s not found", userName));
                }
            }
        }
        parking
                .entrySet()
                .forEach(u -> System.out.println(String.format("%s => %s", u.getKey(), u.getValue())));
    }
}
