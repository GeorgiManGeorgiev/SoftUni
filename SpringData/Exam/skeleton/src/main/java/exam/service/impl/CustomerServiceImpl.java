package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dtos.jsons.CustomerImportDto;
import exam.model.entities.Customer;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.util.validator.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final static String CUSTOMERS_PATH = "src/main/resources/files/json/customers.json";

    private final CustomerRepository customerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CustomerServiceImpl(exam.repository.CustomerRepository customerRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(CUSTOMERS_PATH)));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder sb = new StringBuilder();

        CustomerImportDto[] customerImportDtos = this.gson.fromJson(this.readCustomersFileContent(), CustomerImportDto[].class);


        for (CustomerImportDto customerImportDto : customerImportDtos) {

            Optional<Customer> byEmail = this.customerRepository.getByEmail(customerImportDto.getEmail());

            if (this.validationUtil.isValid(customerImportDto) && byEmail.isEmpty()) {
                Customer customer = this.modelMapper.map(customerImportDto, Customer.class);
                System.out.println();

                this.customerRepository.saveAndFlush(customer);
                sb.append(String.format("Successfully imported Customer %s %s - %s"
                        , customer.getFirstName(), customer.getLastName(), customer.getEmail())
                ).append(System.lineSeparator());
            } else {

                sb.append("Invalid Customer").append(System.lineSeparator());

            }

        }


        return sb.toString();
    }
}
