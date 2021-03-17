package farm;

public class Cat extends Felime {
    private String breed;
    public Cat(String name, String animalType, Double animalWeight, String livingRegion,String breed) {
        super(name, animalType, animalWeight, livingRegion);
        this.breed=breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }


    @Override
    public void eat(Food food) {
        this.incrementFood(food.getQuantity());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Cat"+super.toString());

        builder.insert(builder.indexOf(",")+1," "
                +this.breed+",");


        return builder.toString();
    }
}
