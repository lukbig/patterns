package com.bigos.patterns.decorator;

public class UpperCaseDecorator extends FullInfoDecorator {

    public UpperCaseDecorator(Citizen citizen) {
        super(citizen);
    }

    @Override
    public String firstName() {
        return super.firstName().toUpperCase();
    }
}
