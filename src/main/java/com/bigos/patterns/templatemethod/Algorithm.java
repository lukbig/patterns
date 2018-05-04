package com.bigos.patterns.templatemethod;

public abstract class Algorithm {
    protected int result = 0;

    void stepOne() {
        result += 2;
    }

    abstract void stepTwo();

    public final int compute() {
        stepOne();
        stepTwo();
        return result;
    }
}
