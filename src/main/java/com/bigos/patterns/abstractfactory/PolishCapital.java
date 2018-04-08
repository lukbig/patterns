package com.bigos.patterns.abstractfactory;

public class PolishCapital implements Capital {

    public static final String CAPITAL_NAME = "Warsaw";

    public String name() {
        return CAPITAL_NAME;
    }
}
