package com.bigos.patterns.memento;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Without violating encapsulation, capture and externalize an object's
 * internal state so that the object can be returned to this state later.
 * The client is the care-taker of the memento, but only the source
 * object can store and retrieve information form the memento.
 * If the client subsequently needs to rollback the source object's state,
 * it hands the memento back to the source object for reinstatement.
 * 1. Originator - the object that knows how to save itself
 * 2. Caretaker - the object that knows why and when the Originator
 * needs to save and restore itself
 * 3. Memento - the lock box that is written and read by the originator,
 * and shepherded by the Caretaker.
 */

class MementoTest {

    private static final String INTERNAL_STATE = "state";
    private static final String ANOTHER_INTERNAL_STATE = "another state";

    private final Originator originator = new Originator(INTERNAL_STATE);
    private final CareTaker careTaker = new CareTaker();

    @Test
    void shouldSaveStateToMemento() {
        Memento memento = originator.saveStateToMemento();

        assertThat(memento.getState()).isEqualTo(INTERNAL_STATE);
    }

    @Test
    void shouldRestoreStateFromMemento() {
        Memento memento = new Memento(ANOTHER_INTERNAL_STATE);

        originator.restoreStateFromMemento(memento);

        assertThat(originator.getState()).isEqualTo(ANOTHER_INTERNAL_STATE);
    }

    @Test
    void shouldReturnFirstMemento() {
        careTaker.add(new Memento(INTERNAL_STATE));
        careTaker.add(new Memento(ANOTHER_INTERNAL_STATE));

        Memento memento = careTaker.get();

        assertThat(memento.getState()).isEqualTo(INTERNAL_STATE);
    }

    @Test
    void shouldReturnNullIfListIsEmpty() {
        Memento memento = careTaker.get();

        assertThat(memento).isNull();
    }
}