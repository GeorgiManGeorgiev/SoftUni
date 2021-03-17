import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.endsWith(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.setMoney(this.money - product.getCost());
            this.products.add(product);
            System.out.printf("%s bought %s%n"
                    , this.name
                    , product.getName());
        } else {
            throw new IllegalStateException(this.name + " can't afford "+ product.getName());

        }

    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - ", this.name));
            if (this.products.isEmpty()){
                sb.append("Nothing bought");
                return sb.toString();
            }
                sb.append(this.getProducts()
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", ")));


        return sb.toString();
    }
}
