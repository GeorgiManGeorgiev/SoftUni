package Garage;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;
    public Car(double fuelQuantity,
               double fuelConsumption,int capacity) {
        super(fuelQuantity,
                fuelConsumption
                +AIR_CONDITIONER_CONSUMPTION,capacity);
    }






}
