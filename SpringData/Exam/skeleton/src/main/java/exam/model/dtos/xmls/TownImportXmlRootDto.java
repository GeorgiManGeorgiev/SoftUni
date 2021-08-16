package exam.model.dtos.xmls;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportXmlRootDto {

    @XmlElement(name = "town")
    private List<TownImportXmlDto> townImportXmlDtos;

    public TownImportXmlRootDto() {
    }

    public List<TownImportXmlDto> getTownImportXmlDtos() {
        return townImportXmlDtos;
    }

    public TownImportXmlRootDto setTownImportXmlDtos(List<TownImportXmlDto> townImportXmlDtos) {
        this.townImportXmlDtos = townImportXmlDtos;
        return this;
    }
}
