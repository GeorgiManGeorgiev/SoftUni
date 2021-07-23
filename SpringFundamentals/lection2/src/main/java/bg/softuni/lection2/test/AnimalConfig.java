package bg.softuni.lection2.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AnimalConfig {
    @Profile("kitty-app")
    @Bean
    public Animal createCat(){
        return new Cat();
    }
    @Profile("doggy-app")
    @Bean
    public Animal createDog(){
        return new Dog();
    }
}
