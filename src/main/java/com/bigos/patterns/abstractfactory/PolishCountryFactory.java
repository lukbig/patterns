package com.bigos.patterns.abstractfactory;

public class PolishCountryFactory implements CountryFactory {
    public Capital capital() {
        return new PolishCapital();
    }

    public Hymn hymn() {
        return new PolishHymn();
    }

    public Symbol symbol() {
        return new PolishSymbol();
    }
}
