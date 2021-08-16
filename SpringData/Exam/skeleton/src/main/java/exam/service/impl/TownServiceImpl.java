package exam.service.impl;


import exam.model.dtos.xmls.TownImportXmlDto;
import exam.model.dtos.xmls.TownImportXmlRootDto;
import exam.model.entities.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
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
import java.util.HashSet;

@Service
public class TownServiceImpl implements TownService {

    private final static String TOWNS_PATH = "src/main/resources/files/xml/towns.xml";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(TOWNS_PATH)));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TownImportXmlRootDto TownImportXmlRootDto = this.xmlParser.parseXml(TownImportXmlRootDto.class, TOWNS_PATH);

        for (TownImportXmlDto townImportXmlDto : TownImportXmlRootDto.getTownImportXmlDtos()) {
            if (this.validationUtil.isValid(townImportXmlDto)) {
                Town town = this.modelMapper.map(townImportXmlDto, Town.class);

                this.townRepository.saveAndFlush(town);

                sb.append(String.format("Successfully imported Town %s",
                        town.getName()))
                        .append(System.lineSeparator());

            } else {

                sb.append("Invalid town").append(System.lineSeparator());
            }

        }


        return sb.toString();
    }
}
