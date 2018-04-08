package com.bigos.patterns.abstractfactory;

public class GermanCapital implements Capital {

    public static final String CAPITAL_NAME = "Berlin";

    public String name() {
        return CAPITAL_NAME;
    }
}
