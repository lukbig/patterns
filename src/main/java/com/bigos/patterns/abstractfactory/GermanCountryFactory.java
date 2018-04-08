package com.bigos.patterns.abstractfactory;

public class GermanCountryFactory implements CountryFactory {
    public Capital capital() {
        return new GermanCapital();
    }

    public Hymn hymn() {
        return new GermanHymn();
    }

    public Symbol symbol() {
        return new GermanSymbol();
    }
}
