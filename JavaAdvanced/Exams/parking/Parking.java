package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data= new ArrayList<>();
    }


    public void add(Car car){
        if (this.capacity>data.size()){
            this.data.add(car);
        }
    }

    

    public boolean remove(String manufacturer, String model){
        boolean isRemoved = false;
        List<Car> toRemove =  new ArrayList<>();
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                toRemove.add(car);
                isRemoved = true;
                break;
            }
        }
        this.data.removeAll(toRemove);
        return  isRemoved;
    }

    public Car getLatestCar(){
         return this.data.stream().sorted((f,s)->s.getYear()-f.getYear()).findFirst().orElse(null);

    }

    public Car getCar(String manufacturer, String model){
        Car carToReturn;
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model)){
                carToReturn = car;
                return  carToReturn;
            }
        }
        return null;
    }

    public int getCount(){
        return this.data.size();
    }

    public String 	getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", this.type))
                .append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();

    }
}
