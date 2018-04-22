package com.bigos.patterns.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class FullInfoDecorator implements Citizen {

    protected Citizen citizen;

    @Override
    public String firstName() {
        return citizen.firstName();
    }

    @Override
    public String secondName() {
        return citizen.secondName();
    }

    @Override
    public Long idNumber() {
        return citizen.idNumber();
    }
}
