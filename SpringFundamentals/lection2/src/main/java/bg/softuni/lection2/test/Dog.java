package bg.softuni.lection2.test;


import org.springframework.stereotype.Component;


public class Dog implements Animal {

    @Override
    public String makeNoise() {
        return "waf-waf";
    }
}
