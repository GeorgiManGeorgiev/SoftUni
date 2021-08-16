package exam.service.impl;

import exam.model.dtos.xmls.ShopImportRootXmlDto;
import exam.model.dtos.xmls.ShopImportXmlDto;
import exam.model.dtos.xmls.TownImportXmlDto;
import exam.model.dtos.xmls.TownImportXmlRootDto;
import exam.model.entities.Shop;
import exam.model.entities.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.util.validator.ValidationUtil;
import exam.util.xmlparser.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private final static String SHOPS_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count()>0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(SHOPS_PATH)));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        ShopImportRootXmlDto shopImportRootXmlDto = this.xmlParser.parseXml(ShopImportRootXmlDto.class, SHOPS_PATH);

        for (ShopImportXmlDto shopImportXmlDto : shopImportRootXmlDto.getShopImportXmlDto()) {

            Optional<Shop> byName = this.shopRepository.findByName(shopImportXmlDto.getName());


            if (this.validationUtil.isValid(shopImportXmlDto) && byName.isEmpty()) {
                Shop shop = this.modelMapper.map(shopImportXmlDto, Shop.class);

                this.shopRepository.saveAndFlush(shop);

                sb.append(String.format("Successfully imported Shop %s - %.0f",
                        shop.getName(),
                        shop.getIncome()))
                        .append(System.lineSeparator());

            } else {

                sb.append("Invalid shop").append(System.lineSeparator());
            }

        }


        return sb.toString();
    }
}
