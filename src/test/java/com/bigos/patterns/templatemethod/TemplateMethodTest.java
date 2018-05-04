package com.bigos.patterns.templatemethod;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
 * Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm’s structure.
 */

class TemplateMethodTest {

    @Test
    void shouldReturnTen() {
        Algorithm algorithm = new AlgorithmAlphaImpl();

        int result = algorithm.compute();

        assertThat(result).isEqualTo(10);
    }

    @Test
    void shouldReturnFour() {
        Algorithm algorithm = new AlgorithmBravoImpl();

        int result = algorithm.compute();

        assertThat(result).isEqualTo(4);
    }
}