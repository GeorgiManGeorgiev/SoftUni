package exam.model.dtos.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopImportRootXmlDto {


    @XmlElement(name = "shop")
    private List<ShopImportXmlDto> shopImportXmlDto;


    public ShopImportRootXmlDto() {
    }

    public List<ShopImportXmlDto> getShopImportXmlDto() {
        return shopImportXmlDto;
    }

    public ShopImportRootXmlDto setShopImportXmlDto(List<ShopImportXmlDto> shopImportXmlDto) {
        this.shopImportXmlDto = shopImportXmlDto;
        return this;
    }
}
