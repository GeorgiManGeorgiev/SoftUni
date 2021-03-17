package C_JavaAdvanced.JavaAdv.DefiningClasses.RawData;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        List<Car> cars = new LinkedList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            int count = 0;
            Tire[] carTires = new Tire[4];
            for (int i = 0; i < 4; i++) {
                carTires[i] = new Tire(Double.parseDouble(tokens[5 + i + count]), Integer.parseInt(tokens[6 + i + count]));
                count++;
            }
            Car car = new Car(model,engine,cargo,carTires);
            cars.add(car);
        }


        String command = scanner.nextLine().trim();
        if ("fragile".equals(command)) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals("fragile") && car.isWithLowTire()){
                    System.out.println(car.getModel());
                }
            }


        }
        if ("flamable".equals(command)) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals("flamable") && car.isWithHighEnginePower()){
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
