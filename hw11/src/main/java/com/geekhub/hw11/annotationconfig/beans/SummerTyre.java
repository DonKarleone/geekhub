package com.geekhub.hw11.annotationconfig.beans;

import org.springframework.beans.factory.annotation.Value;

public class SummerTyre extends Tyre {

    public SummerTyre(@Value("17") int size, @Value("Michelin") String name) {
        super(size, name);
    }

    @Override
    public void action() {
        System.out.println("Summer tyre was chosen");
    }
}
