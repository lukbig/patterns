package com.bigos.patterns.strategy;

public class StrategyFactory {

    public static Strategy findStrategy(StrategyType strategyType) {
        switch (strategyType) {
            case ADD:
                return new AddOperation();
            case MULTIPLY:
                return new MultiplyOperation();
            default:
                throw new IllegalArgumentException("Unknown strategy type");
        }
    }
}
