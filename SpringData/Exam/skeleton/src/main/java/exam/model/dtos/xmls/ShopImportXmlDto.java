package exam.model.dtos.xmls;

;

import org.hibernate.validator.constraints.Length;

import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopImportXmlDto {


    @XmlElement
    private String address;
    @XmlElement(name = "employee-count")
    private int employeeCount;
    @XmlElement
    private BigDecimal income;
    @XmlElement
    private String name;
    @XmlElement(name = "shop-area")
    private int shopArea;
    @XmlElement(name = "town")
    private TownImportXml townImportXml;


    public ShopImportXmlDto() {
    }
    @NotNull
    @Length(min = 4)
    public String getAddress() {
        return address;
    }

    public ShopImportXmlDto setAddress(String address) {
        this.address = address;
        return this;
    }
    @NotNull
    @Min(1)
    @Max(50)
    public int getEmployeeCount() {
        return employeeCount;
    }

    public ShopImportXmlDto setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
        return this;
    }
    @NotNull
    @DecimalMin(value = "20000")
    public BigDecimal getIncome() {
        return income;
    }

    public ShopImportXmlDto setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }
    @NotNull
    @Length(min = 4)
    public String getName() {
        return name;
    }

    public ShopImportXmlDto setName(String name) {
        this.name = name;
        return this;
    }
    @NotNull
    @Min(150)
    public int getShopArea() {
        return shopArea;
    }

    public ShopImportXmlDto setShopArea(int shopArea) {
        this.shopArea = shopArea;
        return this;
    }

    public TownImportXml getTownImportXml() {
        return townImportXml;
    }

    public ShopImportXmlDto setTownImportXml(TownImportXml townImportXml) {
        this.townImportXml = townImportXml;
        return this;
    }
}
