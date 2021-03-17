import javax.management.MBeanRegistration;

public class Topping {

    private String toppingType;
    private double weight;
    private double modifier;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);

    }

    public String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {

                switch (toppingType){
                    case "Meat":
                        this.modifier =1.2;
                        this.toppingType = toppingType;
                        break;
                    case "Sauce":
                        this.modifier =0.9;
                        this.toppingType = toppingType;
                        break;
                    case "Cheese":
                        this.modifier =1.1;
                        this.toppingType = toppingType;
                        break;
                    case "Veggies":
                        this.modifier =0.8;
                        this.toppingType = toppingType;
                        break;

                    default:
                        throw new IllegalArgumentException(
                                String.format("Cannot place %s on top of your pizza."
                                        , toppingType));

                }


    }

    public double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50]."
                    , this.getToppingType()));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * this.weight * this.modifier;
    }

}
