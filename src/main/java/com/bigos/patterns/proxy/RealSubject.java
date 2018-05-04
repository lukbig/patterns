package com.bigos.patterns.proxy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RealSubject implements Subject {

    private final String state;

    @Override
    public String display() {
        return state;
    }
}
