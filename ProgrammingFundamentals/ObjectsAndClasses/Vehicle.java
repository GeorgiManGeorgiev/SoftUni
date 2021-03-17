package B_FM.ObjectsAndClasses;

import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle {

    private String type;
    private String model;
    private String color;
    private int horsepower;


    public Vehicle(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {

        String result = String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                this.type, this.model, this.color, this.horsepower);
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);
            Vehicle vehicle;
            if ("car".equals(type)) {
                vehicle = new Vehicle("Car", model, color, horsepower);
                vehicles.add(vehicle);
            } else {
                vehicle = new Vehicle("Truck", model, color, horsepower);
            }

            vehicles.add(vehicle);
            input = scanner.nextLine();
        }
        String model = scanner.nextLine();
        while (!"Close the Catalogue".equals(model)) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(model)) {
                    System.out.println(vehicle);
                    break;
                }
            }

            model = scanner.nextLine();
        }
        double carHp = printHorsePower(vehicles, "Car");
        System.out.println(String.format("Cars have average horsepower of: %.2f.", carHp));
        double truckHp = printHorsePower(vehicles, "Truck");
        System.out.println(String.format("Trucks have average horsepower of: %.2f.", truckHp));
    }

    private static double printHorsePower(ArrayList<Vehicle> vehicles, String type) {
        double sum = 0.0;
        int count = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(type)) {
                sum += vehicle.getHorsepower();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }
}
