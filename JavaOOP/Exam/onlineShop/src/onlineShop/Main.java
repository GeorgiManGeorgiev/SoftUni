package onlineShop;

import onlineShop.core.EngineImpl;
import onlineShop.core.interfaces.Engine;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.computers.Laptop;

public class Main {
    public static void main(String[] args) {
        Laptop laptop =  new Laptop(1,"One","One",2);
        System.out.println(laptop.toString());
        Engine engine = new EngineImpl();
        engine.run();
    }
}
