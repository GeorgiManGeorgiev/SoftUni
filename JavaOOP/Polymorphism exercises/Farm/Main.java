package farm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();
        List<Animal> animals = new LinkedList<>();

        while (!line.equals("End")) {

            String[] animalTokens = line.split("\\s+");

            String name = animalTokens[1];
            Double weight = Double.parseDouble(animalTokens[2]);
            String livingRegion = animalTokens[3];
            String animalType = animalTokens[0];

            Animal animal = null;
            switch (animalType) {
                case "Mouse":
                    animal = new Mouse(name, animalType, weight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(name, animalType, weight, livingRegion);
                    break;
                case "Cat":
                    animal = new Cat(name, animalType, weight, livingRegion, animalTokens[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(name, animalType, weight, livingRegion);
                    break;
            }
            animals.add(animal);

            String[] foodTokens = scanner.nextLine().split("\\s+");

            int quantity=Integer.parseInt(foodTokens[1]);

            Food food = foodTokens[0].equals("Meat")
                    ? new Meat(quantity)
                    :new Vegetable(quantity);

            animal.makeSound();
            try {

                animal.eat(food);
            }catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
            line = scanner.nextLine();
        }


        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }

    }
}
