package farm;

public class Mouse extends Mammal{
    public Mouse(String name, String animalType, Double animalWeight, String livingRegion) {
        super(name, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public String toString() {
        return "Mouse"+ super.toString();
    }
}
