package exam.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    private String name;
    private int population;
    private String travelGuide;
    private Set<Customer> customers;
    private Set<Shop> shops;

    public Town() {
    }

    @Column
    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public int getPopulation() {
        return population;
    }

    public Town setPopulation(int population) {
        this.population = population;
        return this;
    }

    @Column(columnDefinition = "text", name = "travel_guide")
    public String getTravelGuide() {
        return travelGuide;
    }

    public Town setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
        return this;
    }

    @OneToMany(mappedBy = "town")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public Town setCustomers(Set<Customer> customers) {
        this.customers = customers;
        return this;
    }
    @OneToMany(mappedBy = "town")
    public Set<Shop> getShops() {
        return shops;
    }

    public Town setShops(Set<Shop> shops) {
        this.shops = shops;
        return this;
    }
}
