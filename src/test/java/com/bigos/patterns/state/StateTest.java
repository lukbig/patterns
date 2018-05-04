package com.bigos.patterns.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The state pattern does not specify where the state transitions
 * will be defined. The choices are two:
 * 1. the context object
 * 2. each individual state pointer
 */

class StateTest {

    private final State state = new State();

    @Test
    void shouldSetStatToOne() {
        state.pull();

        assertThat(state.getState()).isEqualTo(1);
    }

    @Test
    void shouldSetStateToTwo() {
        state.pull();
        state.pull();

        assertThat(state.getState()).isEqualTo(2);
    }

    @Test
    void shouldSetStateToZero() {
        state.pull();
        state.pull();
        state.pull();

        assertThat(state.getState()).isEqualTo(0);
    }
}