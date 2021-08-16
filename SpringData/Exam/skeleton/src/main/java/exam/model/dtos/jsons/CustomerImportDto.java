package exam.model.dtos.jsons;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CustomerImportDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String email;
    @Expose
    private LocalDate registeredOn;
    @Expose
    private TownImportDto town;


    public CustomerImportDto() {
    }

    @NotNull
    @Length(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public CustomerImportDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    @NotNull
    @Length(min = 2)
    public String getLastName() {
        return lastName;
    }

    public CustomerImportDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    @NotNull
    @Pattern(regexp = "^(\\w+@\\w+)(.\\w+){2,}$")
    public String getEmail() {
        return email;
    }

    public CustomerImportDto setEmail(String email) {
        this.email = email;
        return this;
    }
    @NotNull
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public CustomerImportDto setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }
    @NotNull
    public TownImportDto getTown() {
        return town;
    }

    public CustomerImportDto setTown(TownImportDto town) {
        this.town = town;
        return this;
    }
}
