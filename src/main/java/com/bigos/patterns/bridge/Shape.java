package com.bigos.patterns.bridge;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Shape {
    protected Color color;

    abstract String describe();
}
