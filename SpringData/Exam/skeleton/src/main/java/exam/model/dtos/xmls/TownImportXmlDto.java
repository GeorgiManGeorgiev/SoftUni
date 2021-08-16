package exam.model.dtos.xmls;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportXmlDto {

    @XmlElement
    private String name;
    @XmlElement
    private int population;
    @XmlElement(name = "travel-guide")
    private String travelGuide;


    public TownImportXmlDto() {
    }

    @NotNull
    @Length(min = 2)
    public String getName() {
        return name;
    }

    public TownImportXmlDto setName(String name) {
        this.name = name;
        return this;
    }
    @NotNull
    @Min(value = 1)
    public int getPopulation() {
        return population;
    }

    public TownImportXmlDto setPopulation(int population) {
        this.population = population;
        return this;
    }
    @NotNull
    @Length(min = 10)
    public String getTravelGuide() {
        return travelGuide;
    }

    public TownImportXmlDto setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
        return this;
    }
}
