package com.bigos.patterns.abstractfactory;

public class PolishSymbol implements Symbol {

    public static final String DESCRIPTION = "White eagle on red background";

    public String description() {
        return DESCRIPTION;
    }
}
