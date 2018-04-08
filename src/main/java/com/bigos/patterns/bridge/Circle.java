package com.bigos.patterns.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    String describe() {
        log.info("{} circle", color.getName());
        return String.format("%s circle", color.getName());
    }
}
