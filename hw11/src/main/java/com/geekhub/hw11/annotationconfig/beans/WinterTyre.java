package com.geekhub.hw11.annotationconfig.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("winterTyre")
public class WinterTyre extends Tyre {

    public WinterTyre(@Value("17") int size, @Value("Michelin") String name) {
        super(size, name);
    }

    @Override
    public void action() {
        System.out.println("Winter tyre was chosen");
    }
}
