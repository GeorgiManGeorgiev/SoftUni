package exam.model.dtos.jsons;

import com.google.gson.annotations.Expose;

import exam.model.entities.WarrantyType;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class LaptopImportDto {
    @Expose
    private String macAddress;
    @Expose
    private Double cpuSpeed;
    @Expose
    private int ram;
    @Expose
    private int storage;
    @Expose
    private String description;
    @Expose
    private BigDecimal price;
    @Expose
    private WarrantyType warrantyType;
    @Expose
    private ShopImportDto shop;


    public LaptopImportDto() {
    }

    @NotNull
    @Length(min = 8)
    public String getMacAddress() {
        return macAddress;
    }

    public LaptopImportDto setMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    @NotNull
    @DecimalMin(value = "0")
    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public LaptopImportDto setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
        return this;
    }

    @NotNull
    @Min(8)
    @Max(128)
    public int getRam() {
        return ram;
    }

    public LaptopImportDto setRam(int ram) {
        this.ram = ram;
        return this;
    }

    @NotNull
    @Min(128)
    @Max(1024)
    public int getStorage() {
        return storage;
    }

    public LaptopImportDto setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    @NotNull
    @Length(min = 10)
    public String getDescription() {
        return description;
    }

    public LaptopImportDto setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    @DecimalMin(value = "0")
    public BigDecimal getPrice() {
        return price;
    }

    public LaptopImportDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull
    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public LaptopImportDto setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
        return this;
    }

    public ShopImportDto getShop() {
        return shop;
    }

    public LaptopImportDto setShop(ShopImportDto shop) {
        this.shop = shop;
        return this;
    }
}
