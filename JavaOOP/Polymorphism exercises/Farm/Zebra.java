package farm;

public class Zebra extends Mammal {
    public Zebra(String name, String animalType, Double animalWeight, String livingRegion) {
        super(name, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public String toString() {
        return "Zebra" + super.toString();
    }
}
