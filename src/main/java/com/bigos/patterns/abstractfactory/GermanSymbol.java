package com.bigos.patterns.abstractfactory;

public class GermanSymbol implements Symbol {

    public static final String DESCRIPTION = "Black eagle";

    public String description() {
        return DESCRIPTION;
    }
}
