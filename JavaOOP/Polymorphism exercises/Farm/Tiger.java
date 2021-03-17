package farm;

public class Tiger extends Felime{

    public Tiger(String name, String animalType, Double animalWeight, String livingRegion) {
        super(name, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!food.getType().equals("Meat")){
            throw new IllegalStateException("Tigers are not eating that type of food!");
        }

        super.incrementFood(food.getQuantity());
    }

    @Override
    public String toString() {
        return "Tiger"+ super.toString();
    }
}
