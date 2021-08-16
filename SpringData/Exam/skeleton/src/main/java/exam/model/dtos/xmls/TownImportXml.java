package exam.model.dtos.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportXml {
    @XmlElement
    private String name;

    public String getName() {
        return name;
    }

    public TownImportXml setName(String name) {
        this.name = name;
        return this;
    }
}
