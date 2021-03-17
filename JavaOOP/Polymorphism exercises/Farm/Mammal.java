package farm;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, String animalType, Double animalWeight, String livingRegion) {
        super(name, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (food.getType().equals("Meat")) {
            String type = getAnimalType().equals("Mouse")
                    ? "Mice"
                    : "Zebras";

            throw new IllegalStateException(type + " are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());

      builder.insert(builder.lastIndexOf(",")+1," "
      +this.livingRegion+",");

        return builder.toString();
    }
}
