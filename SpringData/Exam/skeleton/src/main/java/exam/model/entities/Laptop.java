package exam.model.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

    private String macAddress;
    private Double cpuSpeed;
    private int ram;
    private int storage;
    private String description;
    private BigDecimal price;
    private WarrantyType warrantyType;
    private Shop shop;

    public Laptop() {
    }

    @Column(name = "mac_address")
    public String getMacAddress() {
        return macAddress;
    }

    public Laptop setMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    @Column(name = "cpu_speed")
    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public Laptop setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
        return this;
    }

    @Column
    public int getRam() {
        return ram;
    }

    public Laptop setRam(int ram) {
        this.ram = ram;
        return this;
    }

    @Column
    public int getStorage() {
        return storage;
    }

    public Laptop setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    @Column(columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    public Laptop setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public Laptop setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "warranty_type")
    @Enumerated(EnumType.ORDINAL)
    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public Laptop setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    public Shop getShop() {
        return shop;
    }

    public Laptop setShop(Shop shop) {
        this.shop = shop;
        return this;
    }
}
