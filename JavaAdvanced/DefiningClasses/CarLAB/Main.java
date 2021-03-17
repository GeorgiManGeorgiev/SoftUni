package C_JavaAdvanced.JavaAdv.DefiningClasses.CarLAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];
            Car car;
            if (tokens.length == 3) {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                car = new Car(brand, model, horsePower);
            } else if (tokens.length == 2) {
                String model = tokens[1];
                car = new Car(brand, model);
            } else {
                car = new Car(brand);
            }

            cars.add(car);

        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }

    }
}
