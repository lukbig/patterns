package com.bigos.patterns.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyTest {

    private static final int INT_ALPHA = 2;
    private static final int INT_BRAVO = 5;

    @Test
    void shouldAddInts() {
        Strategy strategy = StrategyFactory.findStrategy(StrategyType.ADD);

        int result = strategy.doOperation(INT_ALPHA, INT_BRAVO);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldMultiplyInts() {
        Strategy strategy = StrategyFactory.findStrategy(StrategyType.MULTIPLY);

        int result = strategy.doOperation(INT_ALPHA, INT_BRAVO);

        assertThat(result).isEqualTo(10);
    }
}