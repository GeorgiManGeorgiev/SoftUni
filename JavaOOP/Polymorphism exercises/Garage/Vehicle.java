package Garage;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private int capacity;
    private DecimalFormat formatter;


    protected Vehicle(double fuelQuantity,
                      double fuelConsumption,
                      int capacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.capacity = capacity;
        this.formatter = new DecimalFormat("##.##");
    }


    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;
        if (fuelNeeded > this.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling";

        }
        this.fuelQuantity -= fuelNeeded;
        return this.getClass().getSimpleName() + " travelled " + formatter.format(distance) + " km";
    }

    public void refuel(double quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + quantity > this.capacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += quantity;
    }

    protected void increaseConsumption(double additionalConsumption) {
        this.fuelConsumption += additionalConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f"
                , this.getClass()
                        .getSimpleName(),
                this.fuelQuantity);
    }
}
