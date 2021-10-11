package bg.softuni.mobilele.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<ModelEntity> models;

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}


