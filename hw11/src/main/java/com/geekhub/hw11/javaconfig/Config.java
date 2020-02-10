package com.geekhub.hw11.javaconfig;

import com.geekhub.hw11.javaconfig.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Bean
    public Engine engine() {
        return new Engine(4);
    }

    @Bean
    public Tyre summerTyre() {
        return new SummerTyre(20, "Nokian");
    }

    @Bean
    @Scope("prototype")
    public Wheel wheel() {
        return new Wheel(summerTyre());
    }

    @Bean
    public Car car() {
        List<Wheel> list = new ArrayList<>();
        list.add(wheel());
        list.add(wheel());
        list.add(wheel());
        list.add(wheel());
        return new Car(engine(), list);
    }
}
