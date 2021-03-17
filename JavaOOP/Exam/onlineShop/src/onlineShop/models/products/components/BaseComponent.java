package onlineShop.models.products.components;


public abstract class BaseComponent extends onlineShop.models.products.Component implements Component {
    protected int generation;


    protected BaseComponent(int id,
                            String manufacturer,
                            String model,
                            double price,
                            double overallPerformance,
                            int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.setGeneration(generation);
    }


    @Override
    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Generation: " + this.getGeneration();
    }
}
