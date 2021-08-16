package exam.model.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registeredOn;
    private Town town;

    public Customer() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "registered_on")
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public Customer setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }
    @ManyToOne
    @JoinColumn(name = "town_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Town getTown() {
        return town;
    }

    public Customer setTown(Town town) {
        this.town = town;
        return this;
    }
}
