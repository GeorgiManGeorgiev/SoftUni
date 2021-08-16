package exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import exam.util.validator.ValidationUtil;
import exam.util.validator.ValidationUtilImpl;
import exam.util.xmlparser.XmlParser;
import exam.util.xmlparser.XmlParserImpl;

import javax.validation.Validation;
import javax.validation.Validator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public BufferedReader reader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    @Bean
    public StringBuilder builder() {
        return new StringBuilder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // for jsons
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> LocalDateTime
                        .parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, typeOfT, context) -> LocalDate
                        .parse(json.getAsString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .create();
    }


    @Bean
    public XmlParser xmlParser() {
        return new XmlParserImpl();
    }

    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    public ValidationUtil validatorUtil() {
        return new ValidationUtilImpl(validator());
    }


}
