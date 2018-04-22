package com.bigos.patterns.decorator;

public class PolishCitizen implements Citizen {
    @Override
    public String firstName() {
        return "Jan";
    }

    @Override
    public String secondName() {
        return "Kowalski";
    }

    @Override
    public Long idNumber() {
        return 70121212012L;
    }
}
