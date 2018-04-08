package com.bigos.patterns.abstractfactory;

public class CountryFactoryProvider {

    public static CountryFactory createFactory(CountryType countryType) {
        switch (countryType) {
            case POLAND:
                return new PolishCountryFactory();
            case GERMANY:
                return new GermanCountryFactory();
            default:
                throw new IllegalArgumentException("Unknown country type");
        }
    }
}
