package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dtos.jsons.LaptopImportDto;
import exam.model.entities.Laptop;
import exam.model.entities.Shop;
import exam.model.entities.WarrantyType;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.validator.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final static String LAPTOPS_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ShopRepository shopRepository;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, ShopRepository shopRepository) {
        this.laptopRepository = laptopRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.shopRepository = shopRepository;
    }


    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return  String.join("", Files.readAllLines(Path.of(LAPTOPS_PATH)));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();

        LaptopImportDto[] laptopImportDtos = this.gson.fromJson(this.readLaptopsFileContent(), LaptopImportDto[].class);

        System.out.println();
        for (LaptopImportDto laptopImportDto : laptopImportDtos) {
            WarrantyType warrantyType;

            try {
                warrantyType = laptopImportDto.getWarrantyType();

            } catch (Exception e) {
                sb.append("Invalid laptop").append(System.lineSeparator());
                continue;
            }


            Optional<Laptop> byMacAddress =  this.laptopRepository.getOneByMacAddress(laptopImportDto.getMacAddress());

            if (this.validationUtil.isValid(laptopImportDto) && byMacAddress.isEmpty()) {
                System.out.println();


                Shop shop = this.shopRepository.findByName(laptopImportDto.getShop().getName()).get();
                Laptop laptop = this.modelMapper.map(laptopImportDto, Laptop.class);
                System.out.println();
                laptop.setShop(shop);
                System.out.println();



                this.laptopRepository.saveAndFlush(laptop);
                sb.append(String.format("Successfully imported Laptop %s - %.2f - %d - %d"
                        , laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam(), laptop.getStorage())
                ).append(System.lineSeparator());
            } else {

                sb.append("Invalid Laptop").append(System.lineSeparator());

            }

        }


        return sb.toString();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();

        Set<Laptop> laptops = this.laptopRepository.exportLaptops();

        for (Laptop laptop : laptops) {
            System.out.println();
            sb.append(String.format("Laptop - %s", laptop.getMacAddress())).append(System.lineSeparator())
                    .append(String.format("*Cpu speed  - %s", laptop.getCpuSpeed())).append(System.lineSeparator())
                    .append(String.format("**Ram - %s", laptop.getRam())).append(System.lineSeparator())
                    .append(String.format("***Price - %.2f", laptop.getPrice())).append(System.lineSeparator())
                    .append(String.format("#Shop name - %s", laptop.getShop().getName())).append(System.lineSeparator())
                    .append(String.format("##Town  - %s", laptop.getShop().getTown().getName())).append(System.lineSeparator())
            ;
        }

        return sb.toString();
    }
}
