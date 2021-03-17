package Garage;

public class Truck extends Vehicle {

    private static final double
            AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity,
                 double fuelConsumption
            ,int capacity) {
        super(fuelQuantity, fuelConsumption
                +AIR_CONDITIONER_CONSUMPTION,capacity);
    }



    @Override
    public void refuel(double quantity) {
        super.refuel(quantity * 0.95);
    }
}