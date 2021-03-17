package C_JavaAdvanced.JavaAdv.SetsAndMapsAdvanced;
import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();
        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String[] carInfo = line.split(", ");
            String direction = carInfo[0];
            String carPlate = carInfo[1];

            if ("IN".equals(direction)) {
                cars.add(carPlate);
            }else {
                cars.remove(carPlate);
            }
            line = scanner.nextLine();
        }
        if (!cars.isEmpty()) {
            for (String car : cars) {
                System.out.println(car);
            }
        }else {
            System.out.println("Parking Lot is Empty");
        }

    }
}
