package onlineShop.models.products.computers;

public class Laptop extends BaseComputer  {
    private static final double OVERALL_PERFORMANCE = 15;
    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, OVERALL_PERFORMANCE);
    }

}
