package farm;

import java.text.DecimalFormat;

public abstract class Animal implements Eat, ProduceSound {
    private String name;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String name,
                  String animalType,
                  Double animalWeight) {
        this.name = name;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    @Override
    public void eat(Food food) {

        this.foodEaten += food.getQuantity();
    }

    public String getAnimalType() {
        return animalType;
    }

    protected void incrementFood(int quantity){
        this.foodEaten+=quantity;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d]"
                ,this.name
                , new DecimalFormat("##.##")
                        .format(this.animalWeight)
                , this.foodEaten) ;
    }
}
