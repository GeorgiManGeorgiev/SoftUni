package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends onlineShop.models.products.Computer implements Computer {

    protected List<Component> components;
    protected List<Peripheral> peripherals;


    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" Components " + "(").append(this.components.size()).append("):")
                .append(System.lineSeparator());
        for (int i = 0; i < this.components.size(); i++) {
            sb.append("  ").append(components.get(i))
                    .append(System.lineSeparator());

        }
        sb.append(" Peripherals " + "(").append(this.peripherals.size()).append(");");

        double totalPerformance = 0;
        double averagePerformance = totalPerformance / peripherals.size();
        for (Product peripheral : peripherals) {
            totalPerformance += peripheral.getOverallPerformance();
        }

        sb.append(" Average Overall Performance " + "(").append(averagePerformance).append("):");


        for (int i = 0; i < peripherals.size(); i++) {
            sb.append("  ").append(peripherals.get(i))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {

            return super.getOverallPerformance();
        }
        double performance = super.getOverallPerformance();
        double sum = 0;
        for (Product component : components) {
            sum += component.getOverallPerformance();
        }
        performance = sum / components.size() + performance;
        return performance;
    }


    @Override
    public double getPrice() {
        double totalPrice = 0;
        totalPrice += super.getPrice();
        for (Product component : components) {
            totalPrice += component.getPrice();
        }
        for (Product peripheral : peripherals) {
            totalPrice += peripheral.getPrice();
        }

        return totalPrice;
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.contains(component)) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.id));
        }
        this.components.add(component);
    }


    @Override
    public Component removeComponent(String componentType) {
        boolean containsType = false;
        for (Product component : components) {
            if (componentType.equals(component.getClass().getSimpleName())) {
                containsType = true;
            }
        }

        if (components.isEmpty() || !containsType) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), this.id));
        }
        return null;
    }

    public void addPeripheral(Peripheral peripheral) {

        if (peripherals.contains(peripheral)) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.id));
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        boolean containsType = false;
        int index = 0;
        for (int i = 0; i < peripherals.size(); i++) {
            if (peripheralType.equals(peripherals.get(i).getClass().getSimpleName())) {
                containsType = true;
                index = i;
            }
        }
        if (peripherals.isEmpty() || !containsType) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.id));
        }
        Peripheral peripheral = (Peripheral) peripherals.get(index);
        peripherals.remove(index);
        return peripheral;
    }

}
