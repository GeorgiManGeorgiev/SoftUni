package C_JavaAdvanced.JavaAdv.DefiningClasses.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getModel() {
        return model;
    }

    public boolean isWithLowTire() {
        for (int i = 0; i < this.tires.length; i++) {
            if (i % 2 == 0) {
                if (this.tires[i].getPressure() < 1.0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWithHighEnginePower(){
        if (this.engine.getPower()>250){
            return true;
        }
        return false;
    }
}
