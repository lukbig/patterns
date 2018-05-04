package com.bigos.patterns.prototype;

import lombok.SneakyThrows;
import lombok.Value;

@Value
public class ConcretePrototype implements Prototype, Cloneable {

    private final String state;

    @SneakyThrows
    @Override
    public ConcretePrototype clonePrototype() {
        return (ConcretePrototype) super.clone();
    }
}
