package com.bigos.patterns.decorator;

public class FullInfoWithDashedDecorator extends FullInfoDecorator {

    public FullInfoWithDashedDecorator(Citizen citizen) {
        super(citizen);
    }

    public String getFullInfo() {
        return String.format("%s-%s-%s", citizen.firstName(), citizen.secondName(), citizen.idNumber());
    }
}
