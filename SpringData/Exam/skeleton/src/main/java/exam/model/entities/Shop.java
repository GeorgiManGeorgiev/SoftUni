package exam.model.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {

    private String name;
    private BigDecimal income;
    private int employeeCount;
    private String address;
    private int shopArea;
    private Town town;
    private Set<Laptop> laptops;

    public Shop() {

    }

    @Column
    public String getName() {
        return name;
    }

    public Shop setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public BigDecimal getIncome() {
        return income;
    }

    public Shop setIncome(BigDecimal income) {
        this.income = income;
        return this;
    }

    @Column(name = "employee_count")
    public int getEmployeeCount() {
        return employeeCount;
    }

    public Shop setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
        return this;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public Shop setAddress(String address) {
        this.address = address;
        return this;
    }

    @Column(name = "shop_area")
    public int getShopArea() {
        return shopArea;
    }

    public Shop setShopArea(int shopArea) {
        this.shopArea = shopArea;
        return this;
    }


    @ManyToOne
    @JoinColumn(name = "town_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Town getTown() {
        return town;
    }

    public Shop setTown(Town town) {
        this.town = town;
        return this;
    }

    @OneToMany(mappedBy = "shop",fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public Shop setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
        return this;
    }
}
