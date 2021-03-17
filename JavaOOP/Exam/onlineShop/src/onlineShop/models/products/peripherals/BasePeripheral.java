package onlineShop.models.products.peripherals;


import onlineShop.models.products.Peripheral;

public abstract class BasePeripheral extends Peripheral implements onlineShop.models.products.peripherals.Peripheral {
    private String connectionType;

    protected BasePeripheral(int id,
                             String manufacturer,
                             String model,
                             double price,
                             double overallPerformance,
                             String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.setConnectionType(connectionType);
    }


    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    @Override
    public String toString() {
        return super.toString() + "Connection Type: " + this.getConnectionType();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getOverallPerformance() {
        return this.overallPerformance;
    }
}
