package com.bigos.patterns.strategy;

public class MultiplyOperation implements Strategy {
    @Override
    public int doOperation(int i1, int i2) {
        return i1 * i2;
    }
}
