package Garage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehiclesByType = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\s+");


        vehiclesByType.put("Car", new Car(Double.parseDouble(input[1]),
                Double.parseDouble(input[2]),
                Integer.parseInt(input[3])));

        input = scanner.nextLine().split("\\s+");
        vehiclesByType.put("Truck", new Truck(Double.parseDouble(input[1]),
                Double.parseDouble(input[2]),
                Integer.parseInt(input[3])));

        input = scanner.nextLine().split("\\s+");
        vehiclesByType.put("Bus", new Bus(Double.parseDouble(input[1]),
                Double.parseDouble(input[2]),
                Integer.parseInt(input[3])));


        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine()
                    .split("\\s+");

            double param = Double.parseDouble(tokens[2]);
            String command = tokens[0];
            String type = tokens[1];

            if (command.equals("Drive") && type.equals("Bus")) {
                System.out.println(((Bus) vehiclesByType.get("Bus")).driveWithPassengers(param));
            } else if (command.contains("Drive")) {
                System.out.println(vehiclesByType.get(type)
                        .drive(param));
            } else if (command.equals("Refuel")) {
                try {

                    vehiclesByType.get(type).refuel(param);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        for (Vehicle vehicle : vehiclesByType.values()) {
            System.out.println(vehicle.toString());
        }
    }

}
