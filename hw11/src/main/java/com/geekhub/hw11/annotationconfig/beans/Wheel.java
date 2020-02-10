package com.geekhub.hw11.annotationconfig.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("wheel")
@Scope("prototype")
public class Wheel {
    private Tyre tyre;

    @Autowired
    public Wheel(Tyre tyre) {
        this.tyre = tyre;
        action();
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public void action() {
        System.out.println("Wheel was created");
    }
}
