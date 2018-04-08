package com.bigos.patterns.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    String describe() {
        log.info("{} rectangle", color.getName());
        return String.format("%s rectangle", color.getName());
    }
}
