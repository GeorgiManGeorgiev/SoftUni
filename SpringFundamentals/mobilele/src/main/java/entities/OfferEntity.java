package entities;

import entities.enums.EngineEnum;
import entities.enums.TransmissionEnum;
import org.springframework.ui.Model;

import javax.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    private String description;
    private String imageUrl;
    private int mileage;
    private int price;
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    private int year;

    @ManyToOne
    private ModelEntity model;


@ManyToOne
private UserEntity user;

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferEntity setPrice(int price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OfferEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", engine=" + engine +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model=" + model +
                ", user=" + user +
                '}';
    }
}
