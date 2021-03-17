package Garage;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, int capacity) {
        super(fuelQuantity, fuelConsumption, capacity);
    }

    @Override
    public String drive(double distance) {
        return super.drive(distance);
    }

    public String driveWithPassengers(double distance) {
        super.increaseConsumption(1.4);
        return this.drive(distance);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
